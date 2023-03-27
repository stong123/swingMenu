package cx.menu;

import com.alibaba.fastjson.JSON;
import cx.pojo.Menu;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Test {
    public static void main(String[] args)
    {
        // ----------------------测试的菜单数据--------------------------
        ArrayList<Menu> menus = new ArrayList<>();
        menus.add(new Menu("1","文件","0",null));
        menus.add(new Menu("2","编辑","0",null));
        menus.add(new Menu("3","资源","0",null));
        menus.add(new Menu("4","新建","1",null));
        menus.add(new Menu("5","打开","1",null));
        menus.add(new Menu("6","保存","2",null));
        menus.add(new Menu("7","文档","4",null));
        menus.add(new Menu("8","工程","5",null));
        menus.add(new Menu("9","显示时间","6",null));
        // ----------------------测试的菜单数据--------------------------
        // 以上数据实际应由数据库提供，本次测试写死

        // 创建生成树的工具类，调用构造树方法得到树形菜单
        List<Menu> menuList = new MenuTree(menus).buildTree();

        final JFrame jf = new JFrame("后端工具");
        jf.setLayout(new FlowLayout(FlowLayout.LEFT));//设置流布局
        jf.setBounds(200,200,500,350);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //用于保存所有的JMenuItem
        HashMap<String, JMenuItem> itemHashMap = new HashMap<>();

        JMenuBar jMenuBar = new JMenuBar();
        for (Menu menu : menuList)
        {
            JMenu jMenu = preOrderCreateMenu(menu, itemHashMap);
            jMenuBar.add(jMenu);
        }

        //对最低级菜单添加方法
        JMenuItem jMenuItem = itemHashMap.get("9");
        jMenuItem.addActionListener((e)->{
            System.out.println("now time:");
            showTime();
        });


        jf.add(jMenuBar);
        jf.setVisible(true);

    }

    //先序遍历MenuTree，创建菜单
    public static JMenu preOrderCreateMenu(Menu root , HashMap<String, JMenuItem> itemHashMap)
    {
        if(root == null) return null;
        HashMap<String, JMenu> menuHashMap = new HashMap<>();   //用于存放已经创建的JMenu
        Stack<Menu> stack = new Stack<>();
        //进栈前创建jMenu,并将创建好的jMenu放入hashmap
        JMenu jMenu = new JMenu(root.getName());
        menuHashMap.put(root.getId(), jMenu);
        stack.push(root);
        while(!stack.isEmpty())
        {
            Menu menu = stack.pop();
            //每次出栈时检查是否含有子菜单，若包含，则创建并放入父菜单中
            JMenu pMenu = menuHashMap.get(menu.getId());
            if(menu.getChildren()!=null && !menu.getChildren().isEmpty())
            {
                for (int i = menu.getChildren().size()-1; i >= 0 ; i--)
                {
                    Menu child = menu.getChildren().get(i);
                    //判断该结点是否为叶子结点，若为叶子结点，则创建menuItem
                    if(child.getChildren().isEmpty())
                    {
                        JMenuItem menuItem = new JMenuItem(child.getName());
                        itemHashMap.put(child.getId(), menuItem);
                        pMenu.add(menuItem);
                    }
                    else
                    {
                        JMenu cMenu = new JMenu(child.getName());
                        menuHashMap.put(child.getId(), cMenu);
                        pMenu.add(cMenu);
                    }
                    stack.push(child);
                }
            }
        }
        return jMenu;
    }


    //测试方法
    public static void showTime()
    {
        System.out.println(String.valueOf(System.currentTimeMillis()));
    }
}