package cn.xf.day9_innerNet_connection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.Socket;
import java.util.List;

public class TCP_Signin_Window extends JFrame {

    private JTextArea messageDisplay;
    private JTextArea messageInput;
    private JButton sendButton;
//    private JTextArea onlineUsersDisplay;
    private JList<String> onlineUsersDisplay = new JList<>();
    private Socket socket;

    public TCP_Signin_Window(String name, Socket socket) {
        this();// 初始化界面
        this.setTitle("局域网聊天 - " + name);
        this.socket = socket;
        // 马上开始处理接收到的消息 TCP_Channel_Reader
        new TCP_Channel_Reader(socket,this).run();
    }


    // 接收当前登录人信息
    public TCP_Signin_Window() {
        // 设置窗口大小
        setSize(800, 600);
        setLayout(new BorderLayout());
        // 设置窗口关闭操作
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);// 窗口剧中

        // 创建主面板
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // 创建消息展示框
        messageDisplay = new JTextArea();
        messageDisplay.setEditable(false);
        messageDisplay.setFont(new Font("楷体", Font.PLAIN, 14));
        messageDisplay.setLineWrap(true);
        messageDisplay.setWrapStyleWord(true);
        JScrollPane messageScrollPane = new JScrollPane(messageDisplay);
        messageScrollPane.setBorder(BorderFactory.createTitledBorder("消息展示"));
        mainPanel.add(messageScrollPane, BorderLayout.CENTER);

        // 创建消息输入面板
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.setBorder(BorderFactory.createTitledBorder("输入消息"));

        // 创建消息输入框
        messageInput = new JTextArea(5, 30); // 设置行数为5，列数为30
        messageInput.setFont(new Font("楷体", Font.PLAIN, 14));
        messageInput.setLineWrap(true);
        messageInput.setWrapStyleWord(true);
        messageInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER && !e.isShiftDown()) {
                    sendMessage();
                }
            }
        });
        JScrollPane messageInputScrollPane = new JScrollPane(messageInput);
        inputPanel.add(messageInputScrollPane, BorderLayout.CENTER);

        // 创建发送按钮
        sendButton = new JButton("发送");
        sendButton.setFont(new Font("楷体", Font.BOLD, 14));
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
        inputPanel.add(sendButton, BorderLayout.EAST);

        // 创建在线人数展示框
        onlineUsersDisplay.setFont(new Font("楷体", Font.PLAIN, 14));
        onlineUsersDisplay.setFixedCellWidth(120);
        onlineUsersDisplay.setVisibleRowCount(13);
//        onlineUsersDisplay = new JTextArea();
//        onlineUsersDisplay.setEditable(false);
//        onlineUsersDisplay.setFont(new Font("Arial", Font.PLAIN, 14));
//        onlineUsersDisplay.setLineWrap(true);
//        onlineUsersDisplay.setWrapStyleWord(true);
        JScrollPane onlineUsersScrollPane = new JScrollPane(onlineUsersDisplay);
        onlineUsersScrollPane.setBorder(BorderFactory.createTitledBorder("在线人数"));
        mainPanel.add(onlineUsersScrollPane, BorderLayout.EAST);

        // 将消息输入面板添加到主面板
        mainPanel.add(inputPanel, BorderLayout.SOUTH);

        // 将主面板添加到窗口
        add(mainPanel);

        // 设置窗口居中显示
        setLocationRelativeTo(null);

        // 设置窗口可见
        setVisible(true);
    }

    private void sendMessage() {
        String message = messageInput.getText().trim();
        if (!message.isEmpty()) {
            // 显示发送的消息
            messageDisplay.append("我: " + message + "\n");
            // 清空输入框
            messageInput.setText("");
            // 滚动到底部
            messageDisplay.setCaretPosition(messageDisplay.getDocument().getLength());
        }
    }

    public void refreshOnlineUser(String[] userNames) {
        // 更新在线用户到页面中
        onlineUsersDisplay.setListData(userNames);
    }
}

