package cn.xf.day9_innerNet_connection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.StandardCharsets;

// 用户聊天功能，启动时，输入名称即可进入聊天室
// 登录进入后，展示群聊窗口，展示在线人数，展示消息展示框，输入消息框，发送按钮。可实现群聊，实时展示在线人数
// 完全做到即时通讯
// GUI + 网络编程 + 面向对象设计 + 常用API
public class TCP_StartDemo extends JFrame {

    private JTextField nicknameField;
    private JButton enterButton;
    private JButton cancelButton;

    public TCP_StartDemo() {
        // 设置窗口标题
        setTitle("局域网聊天 - 进入界面");

        // 设置窗口大小
        setSize(400, 200);

        // 设置窗口关闭操作
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建主面板
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // 创建标题标签
        JLabel titleLabel = new JLabel(new String("欢迎进入局域网聊天室".getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8));
        titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 18));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // 创建输入面板
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.setBorder(BorderFactory.createTitledBorder("请输入您的昵称"));

        // 创建昵称输入框
        nicknameField = new JTextField();
        // Arial 字体可能导致乱码
        nicknameField.setFont(new Font("楷体", Font.PLAIN, 14));
        nicknameField.setHorizontalAlignment(JTextField.CENTER);
        nicknameField.setToolTipText("请输入您的昵称");
        inputPanel.add(nicknameField, BorderLayout.CENTER);

        // 创建按钮面板
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // 创建进入按钮
        enterButton = new JButton("进入");
        enterButton.setFont(new Font("楷体", Font.BOLD, 14));
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nickname = nicknameField.getText().trim();
                if (!nickname.isEmpty()) {
                    // 处理进入逻辑
                    System.out.println("用户 " + nickname + " 进入聊天室");
                    // 关闭当前窗口
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(TCP_StartDemo.this, "昵称不能为空", "提示", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // 创建取消按钮
        cancelButton = new JButton("取消");
        cancelButton.setFont(new Font("楷体", Font.BOLD, 14));
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 处理取消逻辑
                System.out.println("用户取消进入聊天室");
                // 关闭当前窗口
                dispose();
            }
        });

        // 将按钮添加到按钮面板
        buttonPanel.add(enterButton);
        buttonPanel.add(cancelButton);

        // 将输入面板和按钮面板添加到主面板
        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // 将主面板添加到窗口
        add(mainPanel);

        // 设置窗口居中显示
        setLocationRelativeTo(null);

        // 设置窗口可见
        setVisible(true);
    }

    public static void main(String[] args) {
        // 设置系统默认字符集为 UTF-8
        System.setProperty("file.encoding", "UTF-8");

        // 创建并显示窗口
        new TCP_StartDemo();
    }
}
