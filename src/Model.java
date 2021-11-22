import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class Model
{

    // general crafting variables
    static int quantity = 1; // item quantity
    static int time = 2; // macro time
    static Point mouseCords = new Point(0, 0); // synthesis button location
    static Point mouseCordRand = new Point(0, 0); // synthesis bot click place

    // 1st macro button
    static boolean shift1 = false;
    static boolean ctrl1 = false;
    static boolean alt1 = false;
    static String button1 = "AA";

    // 2nd macro button
    static boolean shift2 = false;
    static boolean ctrl2 = false;
    static boolean alt2 = false;
    static String button2 = "BB";
    static int macro1Time = 0;

    // crafting
    static boolean crafting = false;
    static boolean emergencyExit = false;
    static boolean reset = false;
    static int macroButtons = 0;
    static AtomicBoolean keepRunning = new AtomicBoolean(true);

    // getters/setters
    // general crafting variables
    public void setQuantity(int amount)
    {
        if (amount >= 1 && amount <= 999)
        {
            quantity = amount;
        }
    }

    public static int getQuantity()
    {
        return quantity;
    }

    public void setTime(int seconds)
    {
        if (seconds >= 1 && seconds <= 180)
        {
            time = seconds;
        }
    }

    public static int getTimeSeconds()
    {
        return time;
    }

    public static int getTimeMillisec() {
        return time*1000;
    }

    public void setMouseCords(Point xy)
    {
        mouseCords = xy;
    }

    public Point getMouseCords()
    {
        return mouseCords;
    }

    public int getMouseCordsXInt()
    {
        return mouseCords.x;
    }

    public int getMouseCordsYInt()
    {
        return mouseCords.y;
    }

    public void setMouseCordsRand(Point xy)
    {
        mouseCordRand = xy;
    }

    public void setMouseCordsRandX(int x)
    {
        mouseCordRand.x = x;
    }

    public void setMouseCordsRandY(int y)
    {
        mouseCordRand.y = y;
    }

    public Point getMouseCordsRand()
    {
        return mouseCordRand;
    }

    public int getMouseCordsXIntRand()
    {
        return mouseCordRand.x;
    }

    public int getMouseCordsYIntRand()
    {
        return mouseCordRand.y;
    }

    // macro button 1
    public void setShift1False()
    {
        shift1 = false;
    }

    public void setCtrl1False()
    {
        ctrl1 = false;
    }

    public void setAlt1False()
    {
        alt1 = false;
    }

    public void setShift1True()
    {
        shift1 = true;
    }

    public void setCtrl1True()
    {
        ctrl1 = true;
    }

    public void setAlt1True()
    {
        alt1 = true;
    }

    public void setButton1(String key)
    {
        if (key.length() == 1 && Character.isLetterOrDigit(key.charAt(0)))
        {
            button1 = key.toUpperCase();
        } else if (key.isBlank())
        {
            button1 = "AA";
        }
    }

    public boolean getShift1() {
        return shift1;
    }

    public boolean getCtrl1() {
        return ctrl1;
    }

    public boolean getAlt1() {
        return alt1;
    }

    public String getButton1() {
        return button1;
    }

    // macro button 2
    public void setShift2False()
    {
        shift2 = false;
    }

    public void setCtrl2False()
    {
        ctrl2 = false;
    }

    public void setAlt2False()
    {
        alt2 = false;
    }

    public void setShift2True()
    {
        shift2 = true;
    }

    public void setCtrl2True()
    {
        ctrl2 = true;
    }

    public void setAlt2True()
    {
        alt2 = true;
    }

    public void setButton2(String key)
    {
        if (key.length() == 1 && Character.isLetterOrDigit(key.charAt(0)))
        {
            button2 = key.toUpperCase();
        } else if (key.isBlank())
        {
            button2 = "BB";
        }
    }

    public boolean getShift2() {
        return shift2;
    }

    public boolean getCtrl2() {
        return ctrl2;
    }

    public boolean getAlt2() {
        return alt2;
    }

    public String getButton2() {
        return button2;
    }

    public void setMacro1Time(int i) {
        macro1Time = i;
    }

    public int getMacro1Time() {
        return macro1Time;
    }

    public int getMacro1TimeMillisec() {
        return macro1Time*1000;
    }

    // crafting
    public void setCraftingStatus(boolean b)
    {
        crafting = b;
    }

    public boolean getCraftingStatus()
    {
        return crafting;
    }

    public void setEmergencyStatus(boolean b)
    {
        emergencyExit = b;
    }

    public boolean getEmergencyStatus()
    {
        return emergencyExit;
    }

    public void stopKeepRunning() {
        keepRunning.set(false);
    }

    public void startKeepRunning() {
        keepRunning.set(true);
    }

    public boolean getKeepRunning() {
        return keepRunning.get();
    }

    public void setReset(boolean b) {
        reset = b;
    }

    public boolean getReset() {
        return reset;
    }

    public void setMacroButtons(int i)
    {
        switch (i)
        {
            case 0:
                macroButtons = 0;
                break;
            case 1:
                macroButtons = i;
                break;
            case 2:
                macroButtons = i;
                break;
            default:
                macroButtons = 0;
                break;
        }
    }

    public int getMacroButtons()
    {
        return macroButtons;
    }

    // formulas
    public void randomCords()
    {
        Random randCord = new Random();
        int randX = randCord.nextInt(70) - 35;
        int randY = randCord.nextInt(8) - 5;
        setMouseCordsRandX(getMouseCordsXInt() + randX);
        setMouseCordsRandY(getMouseCordsYInt() + randY);
    }

    public String establishFinishTime()
    {
        LocalDateTime start = LocalDateTime.now();
        //in milliseconds:
        // Button to start delay = 1500 + random(1000);
        // Mouse click delay = 200 + random(-30 to 70)
        // Button to make delay = 200 + random (-30 to 40)
        // finish wait delay = 2000 + random(2000)
        //in seconds:
        int randomTimeVar = Math.toIntExact((Math.round( (1.5 * quantity) + (0.340*quantity) + (2*quantity) )));
        LocalDateTime finish = start.plusSeconds((quantity * time) + randomTimeVar);
        return finish.format(DateTimeFormatter.ofPattern("HH:mm:ss", Locale.ENGLISH));
    }

    public String establishFinishTime2()
    {
        //same as above and
        // finish macro1 delay = 1000 + random (500)
        // Button to make2 delay = 200 + random (-30 to 40)
        // finish wait delay = 2000 + random (2000)
        //in seconds:
        LocalDateTime start = LocalDateTime.now();
        int randomTimeVar = Math.toIntExact((Math.round( (1.5 * quantity) + (0.340*quantity) + (quantity) + (0.170*quantity) + (2*quantity) )));
        LocalDateTime finish = start.plusSeconds((quantity * time) + randomTimeVar);
        return finish.format(DateTimeFormatter.ofPattern("HH:mm:ss", Locale.ENGLISH));
    }

    public static String getTimeNow() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss", Locale.ENGLISH));
    }

}
