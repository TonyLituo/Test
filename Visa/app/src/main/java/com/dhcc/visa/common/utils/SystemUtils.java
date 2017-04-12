package com.dhcc.visa.common.utils;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.dhcc.visa.app.VisaApplication;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * Created by zhanY on 2017/3/29.
 */

public class SystemUtils {

    /**
     * 获取设备号
     *
     * @param context 上下文
     * @return 设备号
     */
    public static String getDeviceId(Context context) {

        TelephonyManager telephonyManager = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        String imei = telephonyManager.getDeviceId();

        return imei;
    }

    /**
     * 得到本机ip地址
     *
     * @return ip
     */
    public static String getLocalIpAddress() {
        String hostIp = "127.0.0.1";
        try {
            Enumeration<NetworkInterface> nis = NetworkInterface
                    .getNetworkInterfaces();
            InetAddress ia;
            while (nis.hasMoreElements()) {
                NetworkInterface ni = nis.nextElement();
                Enumeration<InetAddress> ias = ni.getInetAddresses();
                while (ias.hasMoreElements()) {
                    ia = ias.nextElement();
                    if (ia instanceof Inet6Address) {
                        continue;// skip ipv6
                    }
                    String ip = ia.getHostAddress();
                    if (!"127.0.0.1".equals(ip)) {
                        hostIp = ia.getHostAddress();
                        break;
                    }
                }
            }
        } catch (SocketException e) {
            Log.e("AppApplication", "网络异常");
        }
        return hostIp;
    }

    /**
     * 得到本机Mac地址
     *
     * @return mac
     */
    public static String getLocalMac() {
        String mac;
        // 获取wifi管理器
        WifiManager wifiMng = (WifiManager) VisaApplication.getApplication().getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfor = wifiMng.getConnectionInfo();
        mac = wifiInfor.getMacAddress();
        return mac;
    }

    /**
     * 获取设备名称
     *
     * @return 设备名称
     */
    public static String getDeciveName() {
        return Build.MANUFACTURER + "-" + Build.MODEL;
    }

}
