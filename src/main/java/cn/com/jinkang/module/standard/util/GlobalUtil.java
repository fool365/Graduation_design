package cn.com.jinkang.module.standard.util;



import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.regex.Pattern;

public class GlobalUtil {
    public static HashMap<String, HashMap<String, Object>> Institutional_Tree = new HashMap();
    public static String Subnode = "";
    public static HashMap<String, String> nodeMap = new HashMap();

    public GlobalUtil() {
    }

    public static String getAppointDate(String format, Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }

    public static Date string2Date(String str, String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);

        try {
            Date date = formatter.parse(str);
            return date;
        } catch (ParseException var4) {
            var4.printStackTrace();
            return null;
        }
    }

    public static long string2Long(String str, String pattern) {
        return date2Long(string2Date(str, pattern));
    }

    public static boolean PasswordVerification(String password) {
        String regex = "^(?![A-Za-z]+$)(?!\\d+$)(?![\\W_]+$)\\S{6,16}$";
        return password.matches(regex);
    }

    public static boolean isEmpty(Object obj) {
        return obj != null && !"".equals(obj.toString()) && !"undefined".equals(obj.toString()) && !"null".equals(obj.toString());
    }

    public static long date2Long(Date date) {
        long time = date.getTime();
        return time;
    }

    public static int string2Int(String str) {
        if (str != null && str.equals("")) {
            return 0;
        } else {
            try {
                return Integer.parseInt(str);
            } catch (Exception var2) {
                return 0;
            }
        }
    }

    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    public static boolean isNumber(String str) {
        Pattern pattern = Pattern.compile("-?[0-9]*.?[0-9]*");
        return pattern.matcher(str).matches();
    }

    public static boolean useLoop(String[] arr, String targetValue) {
        String[] var2 = arr;
        int var3 = arr.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            String s = var2[var4];
            if (s.equals(targetValue)) {
                return true;
            }
        }

        return false;
    }

    public static byte[] objectToByteArray(Object obj) {
        byte[] bytes = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(obj);
            objectOutputStream.flush();
            bytes = byteArrayOutputStream.toByteArray();
        } catch (IOException var17) {
            var17.getMessage();
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException var16) {
                    var16.getMessage();
                }
            }

            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException var15) {
                    var15.getMessage();
                }
            }

        }

        return bytes;
    }

    public static Object byteArrayToObject(byte[] bytes) {
        Object obj = null;
        ByteArrayInputStream byteArrayInputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            byteArrayInputStream = new ByteArrayInputStream(bytes);
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            obj = objectInputStream.readObject();
        } catch (Exception var17) {
            var17.getMessage();
        } finally {
            if (byteArrayInputStream != null) {
                try {
                    byteArrayInputStream.close();
                } catch (IOException var16) {
                    var16.getMessage();
                }
            }

            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException var15) {
                    var15.getMessage();
                }
            }

        }

        return obj;
    }

    public static void AnalysisInstitutionalTree(HashMap<String, HashMap<String, Object>> map) {
        Iterator it = map.entrySet().iterator();

        while(it.hasNext()) {
            Entry<String, HashMap<String, Object>> entry = (Entry)it.next();
            HashMap<String, Object> hash = (HashMap)entry.getValue();
            String key = (String)entry.getKey();
            Subnode = "";
            AnalysisInstitutionalTreeNode(hash);
            nodeMap.put(key, Subnode);
        }

    }

    public static void AnalysisInstitutionalTreeNode(HashMap<String, Object> map) {
        String id = map.get("id").toString();
        if ("".equals(Subnode)) {
            Subnode = id;
        } else {
            Subnode = Subnode + "," + id;
        }

        if (map.containsKey("childNode")) {
            ArrayList<Object> list = (ArrayList)map.get("childNode");
            Iterator it = list.iterator();

            while(it.hasNext()) {
                HashMap<String, Object> hsah = (HashMap)it.next();
                AnalysisInstitutionalTreeNode(hsah);
            }
        }

    }

    public static <T> T[] concat(T[] first, T[] second) {
        T[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }

    public static <T> T[] concatAll(T[] first, T[]... rest) {
        int totalLength = first.length;
        Object[][] var3 = rest;
        int offset = rest.length;

        for(int var5 = 0; var5 < offset; ++var5) {
            T[] array = (T[]) var3[var5];
            totalLength += array.length;
        }

        T[] result = Arrays.copyOf(first, totalLength);
        offset = first.length;
        Object[][] var10 = rest;
        int var11 = rest.length;

        for(int var7 = 0; var7 < var11; ++var7) {
            T[] array = (T[]) var10[var7];
            System.arraycopy(array, 0, result, offset, array.length);
            offset += array.length;
        }

        return result;
    }
}

