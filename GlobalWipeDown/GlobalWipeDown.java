import java.util.regex.Pattern;
import java.util.regex.MatchResult;
import java.util.Arrays;
import java.util.List;
import java.text.DecimalFormat;
class GlobalWipeDown {
    public static Object downloadtime(String filesize, String speed){
        double fileSizeBytes = 0.0;
        double connectionSpeedBitsPerSec = 0.0;

        if (filesize.endsWith("kb")) {
            fileSizeBytes = Double.parseDouble(filesize.substring(0, filesize.length() - 2)) * 1000;
        }
        else if (filesize.endsWith("mb")) {
            fileSizeBytes = Double.parseDouble(filesize.substring(0, filesize.length() - 2)) * 1000000;
        }
        else if (filesize.endsWith("gb")) {
            fileSizeBytes = Double.parseDouble(filesize.substring(0, filesize.length() - 2)) * 1000000000;
        }
        else {
            return null;
        }
        if (speed.endsWith("mbps")) {
            connectionSpeedBitsPerSec = Double.parseDouble(speed.substring(0, speed.length() - 4)) * 1000000;
        }
        else {
            return null;
        }

        double downloadTimeMinutes = fileSizeBytes * 8 / connectionSpeedBitsPerSec / 60;

        DecimalFormat df = new DecimalFormat("#.###");
        return Double.parseDouble(df.format(downloadTimeMinutes));
    }

    public static void main(String [] args) {
        String fileSize = "23kb";
        String connectionSpeed = "2mbps";

        Object downloadTime = GlobalWipeDown.downloadtime(fileSize, connectionSpeed);

        System.out.println(downloadTime);
    }
}
