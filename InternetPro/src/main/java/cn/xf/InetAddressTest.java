package cn.xf;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InetAddressTest {
    public static void main(String[] args) throws Exception {
        // 获取当前网络中所有设备
//        List<String> list = getDevicesInLnLAN();
//
//        for (String s : list) {
////            String s1 = detectType(s);
//            System.out.println(s);
//        }

    }

    // 1.1.获取网络中的设备
    private static List<String> getDevicesInLnLAN() throws Exception {
        List<String> result = new ArrayList<>();

        // 获取当前主机网接口
        InetAddress host = InetAddress.getLocalHost();
        NetworkInterface inetAddress = NetworkInterface.getByInetAddress(host);

        if (inetAddress == null)
            throw new Exception("获取网卡失败");

        // 获取子网掩码
        short prefixLength = inetAddress.getInterfaceAddresses().get(0).getNetworkPrefixLength();
        int subnetMask = 0xffffffff << (32 - prefixLength);
        System.out.println("子网掩码为：" + subnetMask);

        // 计算范围
        byte[] ip = host.getAddress();
        int baseIp = (ip[0] & 0xFF) << 24 | (ip[1] & 0xFF) << 16 | (ip[2] & 0xFF) << 8 | (ip[3] & 0xFF);
        System.out.println(baseIp);
        int network = baseIp & subnetMask;
        System.out.println("网段为：" + network);


        ExecutorService executor = Executors.newFixedThreadPool(50);
        List<Callable<Void>> tasks = new ArrayList<>();
        // 便利子网掩码
        for (int i = 0; i < (~subnetMask - 1); i++) {
            int targetIp = network + i;
            // 目标地址
            InetAddress target = InetAddress.getByAddress(new byte[]{
                    (byte) (targetIp >> 24),
                    (byte) (targetIp >> 16),
                    (byte) (targetIp >> 8),
                    (byte) targetIp
            });
            // 1.1是否能访问
//            if (target.isReachable(1000)) { // 超时时间
//                result.add(target.getHostAddress() + " " + target.getHostName() + "  " + target.getCanonicalHostName());
//            }

            // 1.2.使用多线程提高速度

            tasks.add(() -> {
                if (target.isReachable(1000)) { // 超时时间
                    System.out.println(target.getHostAddress() + " " + target.getHostName() + "  " + target.getCanonicalHostName());
                    result.add(target.getHostAddress());
                }
                return null;
            });
        }

        // 1.2.执行任务
        executor.invokeAll(tasks);
        executor.shutdown();

        return result;
    }

    // 1.3.获取设备类型
    private static String detectType(String ip) throws Exception {
        InetAddress address = InetAddress.getByName(ip);
        // 设备名称
        String deviceName = address.getCanonicalHostName();
        if (deviceName.equals(ip)) {
            String nameBaseType = guessTypeByNames(deviceName);
            if (nameBaseType != null)
                return nameBaseType;
        }

        // 获取 MAC 地址与厂商推测
        String macAddress = getMacAddress(address);
        if (macAddress != null) {
            String type = guessTypeByMac(macAddress);
            if (type != null) return type;
        }
        return "undefined";
    }

    // 1.3.通过设备名称推测类型
    private static String guessTypeByNames(String deviceName) {
        deviceName = deviceName.toLowerCase();
        if (deviceName.contains("router")) return "路由器";
        if (deviceName.contains("printer")) return "打印机";
        if (deviceName.contains("phone")) return "手机";
        if (deviceName.contains("desktop")) return "台式电脑";
        if (deviceName.contains("laptop")) return "笔记本电脑";
        return null;
    }

    // 通过 IP 获取 MAC 地址
    private static String getMacAddress(InetAddress ip) throws Exception {
        NetworkInterface network = NetworkInterface.getByInetAddress(ip);
        if (network == null) {
            return null;
        }

        byte[] mac = network.getHardwareAddress();
        if (mac == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mac.length; i++) {
            sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
        }
        return sb.toString();
    }

    // 基于 MAC 地址前缀推测设备厂商和类型
    private static String guessTypeByMac(String macAddress) {
        // 使用厂商 OUI 前缀
        Map<String, String> macVendorMap = new HashMap<>();
        macVendorMap.put("00:1A:2B", "苹果设备");
        macVendorMap.put("FC:FB:FB", "小米设备");
        macVendorMap.put("C8:3A:35", "华为设备");
        macVendorMap.put("A4:34:F1", "路由器");

        String prefix = macAddress.substring(0, 8);
        return macVendorMap.getOrDefault(prefix, null);
    }
}
