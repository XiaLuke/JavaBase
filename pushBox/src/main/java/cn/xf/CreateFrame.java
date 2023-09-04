package cn.xf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CreateFrame extends JFrame implements ActionListener, ItemListener {
    JLabel lb;
    JLabel lb2;
    JButton btnrenew, btnlast, btnnext, btnchoose, btnfirst, btnover, btnmuc, btnback;
    CreatePanel panel;
    SoundSource sound;
    JComboBox jc = new JComboBox();
    MenuItem renew = new MenuItem("    重新开始");
    MenuItem back = new MenuItem("    悔一步");
    MenuItem last = new MenuItem("    上一关");
    MenuItem next = new MenuItem("    下一关");
    MenuItem choose = new MenuItem("    选关");
    MenuItem exit = new MenuItem("    退出");
    MenuItem qin = new MenuItem("    琴萧合奏");
    MenuItem po = new MenuItem("    泡泡堂");
    MenuItem guang = new MenuItem("    灌篮高手");
    MenuItem nor = new MenuItem("    默认");
    MenuItem eye = new MenuItem("    eyes on me");
    MenuItem about = new MenuItem("    关于推箱子...");

    // 创建窗口，设置基本信息
    CreateFrame() {
        super("推箱子v2.0");
        setSize(720, 720);
        setVisible(true);
        // 窗口是否能让用户自定义大小
        setResizable(false);
        // 设置展示在桌面上的位置
        setLocation(500, 200);
        // 在关闭窗口后停止程序
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置ContentPane
        Container cont = getContentPane();
        cont.setLayout(null);
        // 设置容器背景色
        cont.setBackground(Color.black);

        Menu choice = new Menu("    选项");
        choice.add(renew);
        choice.add(last);
        choice.add(next);
        choice.add(choose);
        choice.add(back);
        choice.addSeparator();
        choice.add(exit);
        renew.addActionListener(this);
        last.addActionListener(this);
        next.addActionListener(this);
        choose.addActionListener(this);
        exit.addActionListener(this);
        back.addActionListener(this);

        Menu setmuc = new Menu("    设置音乐");
        setmuc.add(nor);
        setmuc.add(qin);
        setmuc.add(po);
        setmuc.add(guang);
        setmuc.add(eye);
        nor.addActionListener(this);
        qin.addActionListener(this);
        po.addActionListener(this);
        guang.addActionListener(this);
        eye.addActionListener(this);

        Menu help = new Menu("    帮助");
        help.add(about);
        about.addActionListener(this);
        MenuBar bar = new MenuBar();
        bar.add(choice);
        bar.add(setmuc);
        bar.add(help);
        setMenuBar(bar);

        nor.setEnabled(false);
        lb = new JLabel("灰太狼古堡推箱子！", SwingConstants.CENTER);
        lb2 = new JLabel("更换音乐", SwingConstants.CENTER);
        add(lb);
        add(lb2);
        lb.setBounds(100, 20, 400, 20);
        lb.setForeground(Color.white);
        lb2.setBounds(625, 500, 55, 20);
        lb2.setForeground(Color.white);

        btnrenew = new JButton("重玩");
        btnback = new JButton("悔一步");
        btnlast = new JButton("上一关");
        btnnext = new JButton("下一关");
        btnchoose = new JButton("选关");
        btnfirst = new JButton("第１关");
        btnover = new JButton("最终关");
        btnmuc = new JButton("音乐关");
        add(btnrenew);
        add(btnlast);
        add(btnnext);
        add(btnchoose);
        add(btnfirst);
        add(btnover);
        add(btnmuc);
        add(btnback);
        btnrenew.setBounds(625, 100, 80, 30);
        btnrenew.addActionListener(this);
        btnback.setBounds(625, 150, 80, 30);
        btnback.addActionListener(this);
        btnfirst.setBounds(625, 200, 80, 30);
        btnfirst.addActionListener(this);
        btnlast.setBounds(625, 250, 80, 30);
        btnlast.addActionListener(this);
        btnnext.setBounds(625, 300, 80, 30);
        btnnext.addActionListener(this);
        btnover.setBounds(625, 350, 80, 30);
        btnover.addActionListener(this);
        btnchoose.setBounds(625, 400, 80, 30);
        btnchoose.addActionListener(this);
        btnmuc.setBounds(625, 450, 80, 30);
        btnmuc.addActionListener(this);
        jc.setBounds(625, 530, 80, 20);
        jc.addItem("默认");
        jc.addItem("琴萧合奏");
        jc.addItem("泡泡堂");
        jc.addItem("灌篮高手");
        jc.addItem("eyes on me");
        jc.addItemListener(this);
        cont.add(jc);
        sound = new SoundSource();
        sound.loadSound();
        panel = new CreatePanel();
        add(panel);
        panel.Tuixiangzi(panel.level);
        panel.requestFocus();
        validate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnrenew || e.getSource() == renew) {
            panel.Tuixiangzi(panel.level);
            panel.requestFocus();
            panel.remove();
        } else if (e.getSource() == btnlast || e.getSource() == last) {
            panel.level--;
            if (panel.level < 1) {
                panel.level++;
                JOptionPane.showMessageDialog(this, "本关是第一关");
                panel.requestFocus();
            } else {
                panel.Tuixiangzi(panel.level);
                panel.requestFocus();
            }
            panel.remove();
        } else if (e.getSource() == btnnext || e.getSource() == next) {
            panel.level++;
            if (panel.level > panel.maxlevel()) {
                panel.level--;
                JOptionPane.showMessageDialog(this, "本关已是最后一关");
                panel.requestFocus();
            } else {
                panel.Tuixiangzi(panel.level);
                panel.requestFocus();
            }
            panel.remove();
        } else if (e.getSource() == exit) System.exit(0);
        else if (e.getSource() == about) {
            JOptionPane.showMessageDialog(this, "JAVA推箱子游戏！(version 3.0)");
        } else if (e.getSource() == btnchoose || e.getSource() == choose) {
            String lel = JOptionPane.showInputDialog(this, "请输入您要转到的关卡号：(1~50)");
            panel.level = Integer.parseInt(lel);
            panel.remove();
            if (panel.level > panel.maxlevel() || panel.level < 1) {
                JOptionPane.showMessageDialog(this, "没有这一关！！！");
                panel.requestFocus();
            } else {
                panel.Tuixiangzi(panel.level);
                panel.requestFocus();
            }
        } else if (e.getSource() == btnfirst) {
            panel.level = 1;
            panel.Tuixiangzi(panel.level);
            panel.requestFocus();
            panel.remove();
        } else if (e.getSource() == btnover) {
            panel.level = panel.maxlevel();
            panel.Tuixiangzi(panel.level);
            panel.requestFocus();
            panel.remove();
        } else if (e.getSource() == btnmuc) {
            if (sound.isplay()) {
                sound.mystop();
                btnmuc.setLabel("音乐开");
            } else {
                sound.loadSound();
                btnmuc.setLabel("音乐关");
            }
            panel.requestFocus();
        } else if (e.getSource() == btnback || e.getSource() == back) {
            if (panel.isMystackEmpty()) JOptionPane.showMessageDialog(this, "您还未移动！！！");
            else {
                switch (panel.back()) {
                    case 10:
                        panel.backup(10);
                        break;
                    case 11:
                        panel.backup(11);
                        break;
                    case 20:
                        panel.backdown(20);
                        break;
                    case 21:
                        panel.backdown(21);
                        break;
                    case 30:
                        panel.backleft(30);
                        break;
                    case 31:
                        panel.backleft(31);
                        break;
                    case 40:
                        panel.backright(40);
                        break;
                    case 41:
                        panel.backright(41);
                        break;
                }
            }
            panel.requestFocus();
        } else if (e.getSource() == nor) {
            jc.setSelectedIndex(0);
        } else if (e.getSource() == qin) {
            jc.setSelectedIndex(1);
        } else if (e.getSource() == guang) {

            jc.setSelectedIndex(3);

        } else if (e.getSource() == eye) {
            jc.setSelectedIndex(4);
        } else if (e.getSource() == po) {
            jc.setSelectedIndex(2);
        }
    }


    @Override
    public void itemStateChanged(ItemEvent ie) {
        int no = jc.getSelectedIndex();
        switch (no) {
            case 0:
                sound.setMusic("nor.mid");
                if (sound.isplay()) sound.mystop();
                sound.loadSound();
                btnmuc.setLabel("音乐关");
                nor.setEnabled(false);
                qin.setEnabled(true);
                guang.setEnabled(true);
                eye.setEnabled(true);
                po.setEnabled(true);
                panel.requestFocus();
                break;
            case 1:
                sound.setMusic("qin.mid");
                if (sound.isplay()) sound.mystop();
                sound.loadSound();
                btnmuc.setLabel("音乐关");
                nor.setEnabled(true);
                qin.setEnabled(false);
                guang.setEnabled(true);
                eye.setEnabled(true);
                po.setEnabled(true);
                panel.requestFocus();
                break;
            case 2:
                sound.setMusic("popo.mid");
                if (sound.isplay()) sound.mystop();
                sound.loadSound();
                btnmuc.setLabel("音乐关");
                nor.setEnabled(true);
                qin.setEnabled(true);
                guang.setEnabled(true);
                eye.setEnabled(true);
                po.setEnabled(false);
                panel.requestFocus();
                break;
            case 3:
                sound.setMusic("guang.mid");
                if (sound.isplay()) sound.mystop();
                sound.loadSound();
                btnmuc.setLabel("音乐关");
                nor.setEnabled(true);
                qin.setEnabled(true);
                guang.setEnabled(false);
                eye.setEnabled(true);
                po.setEnabled(true);
                panel.requestFocus();
                break;
            case 4:
                sound.setMusic("eyes on me.mid");
                if (sound.isplay()) sound.mystop();
                sound.loadSound();
                btnmuc.setLabel("音乐关");
                nor.setEnabled(true);
                qin.setEnabled(true);
                guang.setEnabled(true);
                eye.setEnabled(false);
                po.setEnabled(true);
                panel.requestFocus();
                break;
        }
    }
}
