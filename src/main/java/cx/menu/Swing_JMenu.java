package cx.menu;

import java.awt.*;
import javax.swing.*;
public class Swing_JMenu extends JFrame{
 
	//定义组件
	JMenuBar jmb;	//定义菜单栏
	JMenu jm1,jm2,jm3,jm4,jm5;	//定义菜单
	JMenu jm6,jm7,jm8,jm9;		//定义菜单中的菜单
	JMenuItem jmi1,jmi2,jmi3,jmi4,jmi5;		//定义子菜单
	public static void main(String[] args) {
		Swing_JMenu a=new Swing_JMenu();
 
	}
	public Swing_JMenu()
	{
		//创建组件
		jmb=new JMenuBar();		//创建菜单栏
		jm1=new JMenu("文件");	//创建菜单
		jm2=new JMenu("编辑");
		jm3=new JMenu("资源");
		jm4=new JMenu("窗口");
		jm5=new JMenu("帮助");
		jm6=new JMenu("新建");
		jm7=new JMenu("打开");
		jm8=new JMenu("保存");
		jm9=new JMenu("导入");
		jmi1=new JMenuItem("文档");	//创建子菜单
		jmi2=new JMenuItem("工程");
		jmi3=new JMenuItem("包");
		jmi4=new JMenuItem("类");
		jmi5=new JMenuItem("接口");
		
		//设置布局管理器
		
		//添加组件
		jm6.add(jmi1);	//把子菜单添加到菜单中
		jm6.add(jmi2);
		jm6.add(jmi3);
		jm6.add(jmi4);
		jm6.add(jmi5);
		
		jm1.add(jm6);	//把菜单添加到菜单中
		jm1.add(jm7);
		jm1.add(jm8);
		jm1.add(jm9);
		
		jmb.add(jm1);	//把菜单添加到菜单栏中
		jmb.add(jm2);
		jmb.add(jm3);
		jmb.add(jm4);
		jmb.add(jm5);
		
		this.add(jmb,BorderLayout.NORTH);	//把菜单栏添加到框架北部
		
		//设置界面属性
		this.setTitle("菜单栏案例");		//设置界面标题
		this.setSize(300, 250);				//设置界面像素
		this.setLocation(200, 200);			//设置界面初始位置
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//设置虚拟机和界面一同关闭
		this.setVisible(true);				//设置界面可视化
	}
}