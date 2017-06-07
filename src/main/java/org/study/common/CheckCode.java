package org.study.common;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.QuadCurve2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.study.common.utils.IOUtils;


/**
 * 验证码
 * 
 * @author Administrator
 *
 */
public class CheckCode {

	/**
	 * 默认验证码字符
	 */
	private static char[] DEFAULT_CODE = "1234567890ABCDEFGHIGKLMNOPQRSTUVWXYZ".toCharArray();

	/**
	 * 随机类
	 */
	private static Random RANDOM = new Random();

	/**
	 * 验证码图片的大小
	 */
	private final static int WIDTH = 108, HEIGHT = 40, CODE_SIZE = 4;

	/**
	 * 验证码字体
	 */
	private static final Font[] RANDOM_FONT = new Font[] { new Font("nyala", Font.BOLD, 38),
			new Font("Arial", Font.BOLD, 32), new Font("Bell MT", Font.BOLD, 32),
			new Font("Credit valley", Font.BOLD, 34), new Font("Impact", Font.BOLD, 32),
			new Font(Font.MONOSPACED, Font.BOLD, 40) };

	/**
	 * 写出验证码图片
	 * 
	 * @param response
	 * @param code
	 */
	public static void genarateCode(HttpServletResponse response, String code) {
		BufferedImage im = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		// 设置响应头
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");

		ServletOutputStream sos = null;

		try {
			drawGraphic(im, code);
			sos = response.getOutputStream();
			ImageIO.write(im, "JPEG", sos);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			IOUtils.closeStream(sos);
		}
	}

	
	/**
	 * 生成验证码字符串
	 * @return 验证码字符串
	 */
	public static String generateCode() {
		int count = CODE_SIZE;
		char[] buffer = new char[count];
		for (int i = 0; i < count; i++) {
			buffer[i] = DEFAULT_CODE[RANDOM.nextInt(DEFAULT_CODE.length)];
		}
		return new String(buffer);
	}
	
	/**
	 * 将文字写入到画布中去
	 */
	private static void drawGraphic(BufferedImage im, String code) {

		Graphics2D gc = im.createGraphics();
		gc.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
		// 图形抗锯齿
		gc.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		// 字体抗锯齿
		gc.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		gc.setColor(getColor(210, 250));
		gc.fillRect(0, 0, WIDTH, HEIGHT);

		// 画小字符背景
		Color color = null;
		for (int i = 0; i < 20; i++) {
			color = getColor(120, 200);
			gc.setColor(color);
			String rand = String.valueOf(DEFAULT_CODE[RANDOM.nextInt(DEFAULT_CODE.length)]);
			gc.drawString(rand, RANDOM.nextInt(WIDTH), RANDOM.nextInt(HEIGHT));
			color = null;
		}
		// 取随机产生的认证码(4位数字)
		char[] buffer = code.toCharArray();
		for (int i = 0; i < buffer.length; i++) {
			char _code = buffer[i];
			// 旋转度数 最好小于45度
			int degree = RANDOM.nextInt(28);
			if (i % 2 == 0) {
				degree = degree * (-1);
			}
			// 定义坐标
			int x = 22 * i, y = 21;
			// 旋转区域
			gc.rotate(Math.toRadians(degree), x, y);
			// 设定字体颜色
			color = getColor(20, 130);
			gc.setColor(color);
			// 设定字体，每次随机
			gc.setFont(RANDOM_FONT[RANDOM.nextInt(RANDOM_FONT.length)]);
			// 将认证码显示到图象中
			gc.drawString("" + _code, x + 8, y + 10);
			// 旋转之后，必须旋转回来
			gc.rotate(-Math.toRadians(degree), x, y);
		}
		// 图片中间曲线，使用上面缓存的color
		gc.setColor(color);
		// width是线宽,float型
		BasicStroke bs = new BasicStroke(3);
		gc.setStroke(bs);
		// 画出曲线
		QuadCurve2D.Double curve = new QuadCurve2D.Double(0d, RANDOM.nextInt(HEIGHT - 8) + 4, WIDTH / 2, HEIGHT / 2,
				WIDTH, RANDOM.nextInt(HEIGHT - 8) + 4);
		gc.draw(curve);
		// 销毁图像
		gc.dispose();

	}

	/**
	 * 问题1：为什么要这么构造一个颜色呢？
	 * 
	 * @param fc
	 * @param bc
	 * @return
	 */
	private static Color getColor(int fc, int bc) {
		if (fc > 255) {
			fc = 255;
		}
		if (bc > 255) {
			bc = 255;
		}

		int sub = bc - fc;

		int r = fc + RANDOM.nextInt(sub);
		int g = fc + RANDOM.nextInt(sub);
		int b = fc + RANDOM.nextInt(sub);

		return new Color(r, g, b);
	}

}
