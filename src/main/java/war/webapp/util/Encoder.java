package war.webapp.util;

public class Encoder {
    public static void main(String[] args) {
        String s = "Пароль был успешно изменен";
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            if ((int) s.charAt(i) < 1000) {
                result += s.charAt(i);
                continue;
            }
            int p = (int) s.charAt(i) - 1040;
            result += codes[p];
        }
        System.out.println(result);
    }

    static String[] codes = new String[]{
            "\\u0410",
            "\\u0411",
            "\\u0412",
            "\\u0413",
            "\\u0414",
            "\\u0415",
            "\\u0416",
            "\\u0417",
            "\\u0418",
            "\\u0419",
            "\\u041A",
            "\\u041B",
            "\\u041C",
            "\\u041D",
            "\\u041E",
            "\\u041F",
            "\\u0420",
            "\\u0421",
            "\\u0422",
            "\\u0423",
            "\\u0424",
            "\\u0425",
            "\\u0426",
            "\\u0427",
            "\\u0428",
            "\\u0429",
            "\\u042A",
            "\\u042B",
            "\\u042C",
            "\\u042D",
            "\\u042E",
            "\\u042F",
            "\\u0430",
            "\\u0431",
            "\\u0432",
            "\\u0433",
            "\\u0434",
            "\\u0435",
            "\\u0436",
            "\\u0437",
            "\\u0438",
            "\\u0439",
            "\\u043A",
            "\\u043B",
            "\\u043C",
            "\\u043D",
            "\\u043E",
            "\\u043F",
            "\\u0440",
            "\\u0441",
            "\\u0442",
            "\\u0443",
            "\\u0444",
            "\\u0445",
            "\\u0446",
            "\\u0447",
            "\\u0448",
            "\\u0449",
            "\\u044A",
            "\\u044B",
            "\\u044C",
            "\\u044D",
            "\\u044E",
            "\\u044F",
    };
}

