��ο��ٴ��һ��ssh���
1.��ͬ��maven������ص�jar����hibernate���������������etc�ļ�����һ��hibernate.properties���ļ�
2.����hibernate.cfg.xml��Ҳ������spring������hibernate���������

����hibernate��
�ص㣺hibernate��5�����Ľӿ�
1.Session�ӿ�     			���𱻳־û������crud������ע�����session�Ƿ��̰߳�ȫ�ģ���httpsession��ͬ
2.SessionFactory�ӿ�		����hibernate�ĳ�ʼ���������������ݴ洢Դ�Ĵ�������session������������������ģ������ֻ��ʼ��һ��
3.Configuration�ӿ�		�������ò�����hibernate�����������ļ�������SessionFactory����
4.Transaction�ӿ�		�����������
5.Query��Criteria�ӿ�	����������ݿ�Ĳ�ѯ����HQL��SQL������ֲ�ѯ��ʽ


ע�����
1.ʹ��hibernate��ܵĺô��Լ�����ȱ��	
	a��ע��Ҫ֪������������������ļ������ԣ������Ҫ���ε����ݣ��Լ��ļ�
2.��spring������Ҫע�������
	a�������ַ�ʽ����һ��ֱ����spring������hibernate�Ĳ������ڶ���ͨ��������Դ�ķ�ʽ������hibernate����ֵ�ļ�
	b��ע�����ӳص�ѡ�ã��Լ����ӳص�����
	c������ģ��ʽ���룬spring�ṩhibernateDaoSupport֧�֣����Ի��һ��ģ���ࣨHibernateTempate������������ṩҵ���߼������ر��ӵĲ�����������������ҵ��Ҫ����Ҫ����execute����������������ݿ�Ĵ洢����
	d��spring��ӵ���������������ע�ⷽʽ�����ã��������ļ���ʽ����Ҫ�˽�spring�����񴫲����ƺ͸��뼶��