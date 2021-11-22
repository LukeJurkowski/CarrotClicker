import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Field;
import java.util.Random;

public class Controller
{
    private Model model;
    private UIMain view;

    public Controller(Model m, UIMain v)
    {
        model = m;
        view = v;

        // listeners being added
        v.spinnerQuantityAddCL(new QuantitySpinnerAL());
        v.spinnerTimeAddCL(new TimeSpinnerCL());
        v.buttonSaveXYAddAL(new MouseCoordsXYAL());
        v.checkBoxShift1AddAL(new Shift1AL());
        v.checkBoxCtrl1AddAL(new Ctrl1AL());
        v.checkBoxAlt1AddAL(new Alt1AL());
        v.checkBoxShift2AddAL(new Shift2AL());
        v.checkBoxCtrl2AddAL(new Ctrl2AL());
        v.checkBoxAlt2AddAL(new Alt2AL());
        v.spinnerMacro1AddCL(new Macro1TimeAL());
        v.buttonCraftAddAL(new CraftingAL());
        v.buttonEmergencyExitAddAL(new EmergencyExitAL());
        v.buttonAboutAddAL(new AboutAL());
        v.buttonResetAddAL(new ResetAL());

    }

    // ----------------------------------------------
    // listeners classes
    class QuantitySpinnerAL implements ChangeListener
    {

        @Override
        public void stateChanged(ChangeEvent e)
        {
            model.setQuantity(view.spinnerGetQuantity());
        }

    }

    class TimeSpinnerCL implements ChangeListener
    {

        @Override
        public void stateChanged(ChangeEvent e)
        {
            model.setTime(view.spinnerGetTime());

        }

    }

    class MouseCoordsXYAL implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            view.buttonSaveXYChangeText("Click on synthesis");
            view.UIUpdate();

            Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener()
            {
                @Override
                public void eventDispatched(AWTEvent event)
                {
                    model.setMouseCords(MouseInfo.getPointerInfo().getLocation());
                    Toolkit.getDefaultToolkit().removeAWTEventListener(this);

                    view.buttonSaveXYChangeText("Save new XY");
                    view.labelCordUpdate(model.getMouseCordsXInt(), model.getMouseCordsYInt());
                    view.UIUpdate();
                }

            }, AWTEvent.FOCUS_EVENT_MASK);
        }

    }

    class Shift1AL implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (view.checkGetShift1())
            {
                model.setShift1True();
            } else
            {
                model.setShift1False();
            }
        }

    }

    class Ctrl1AL implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (view.checkGetCtrl1())
            {
                model.setCtrl1True();
            } else
            {
                model.setCtrl1False();
            }
        }

    }

    class Alt1AL implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (view.checkGetAlt1())
            {
                model.setAlt1True();
            } else
            {
                model.setAlt1False();
            }
        }

    }

    class Shift2AL implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (view.checkGetShift2())
            {
                model.setShift2True();
            } else
            {
                model.setShift2False();
            }
        }

    }

    class Ctrl2AL implements ActionListener

    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (view.checkGetCtrl2())
            {
                model.setCtrl2True();
            } else
            {
                model.setCtrl2False();
            }
        }

    }

    class Alt2AL implements ActionListener

    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (view.checkGetAlt2())
            {
                model.setAlt2True();
            } else
            {
                model.setAlt2False();
            }
        }

    }

    class Macro1TimeAL implements ChangeListener
    {

        @Override
        public void stateChanged(ChangeEvent e)
        {
            model.setMacro1Time(view.spinnerGetMacro1Time());
        }

    }

    // crafting and to make it run additional thread
    class CraftingConcurrency implements Runnable
    {

        @Override
        public void run()
        {
            while (model.getKeepRunning())
            {

                model.setCraftingStatus(true);

                // how many macro buttons

                // only second button
                if (view.textGetKey1().isBlank() && !view.textGetKey2().isBlank())
                {
                    model.setMacroButtons(0);
                    view.textSetKey2("");
                    model.setReset(true);
                }
                // no buttons
                else if (view.textGetKey1().isBlank() && view.textGetKey2().isBlank())
                {
                    model.setMacroButtons(0);
                    model.setReset(true);
                }
                // only 1st button
                else if (!view.textGetKey1().isBlank() && view.textGetKey2().isBlank())
                {
                    model.setMacroButtons(1);
                    model.setButton1(view.textGetKey1());

                    if (view.checkGetShift1())
                    {
                        model.setShift1True();
                    } else {
                        model.setShift1False();
                    }

                    if (view.checkGetCtrl1())
                    {
                        model.setCtrl1True();
                    } else {
                        model.setCtrl1False();
                    }

                    if (view.checkGetAlt1())
                    {
                        model.setAlt1True();
                    } else {
                        model.setAlt1False();
                    }

                }
                // both buttons
                else if (!view.textGetKey1().isBlank() && !view.textGetKey2().isBlank())
                {
                    model.setMacroButtons(2);
                    model.setButton1(view.textGetKey1());
                    model.setButton2(view.textGetKey2());

                    if (view.checkGetShift1())
                    {
                        model.setShift1True();
                    } else {
                        model.setShift1False();
                    }

                    if (view.checkGetCtrl1())
                    {
                        model.setCtrl1True();
                    } else {
                        model.setCtrl1False();
                    }

                    if (view.checkGetAlt1())
                    {
                        model.setAlt1True();
                    } else {
                        model.setAlt1False();
                    }

                    if (view.checkGetShift2())
                    {
                        model.setShift2True();
                    } else {
                        model.setShift2False();
                    }

                    if (view.checkGetCtrl2())
                    {
                        model.setCtrl2True();
                    } else {
                        model.setCtrl2False();
                    }

                    if (view.checkGetAlt2())
                    {
                        model.setAlt2True();
                    } else {
                        model.setAlt2False();
                    }
                }

                // lack of coords X and Y
                if (model.getMouseCordsXInt() == 0 && model.getMouseCordsYInt() == 0)
                {
                    model.setMacroButtons(3);
                    model.setReset(true);
                }


                try
                {
                    Robot robot = new Robot();
                    Random randTime = new Random();
                    switch (model.getMacroButtons())
                    {
                        case 0:
                            view.labelSetFinishTime("Wrong buttons for macro");
                            break;

                        case 1:
                            int quantity = model.getQuantity();
                            String estimateFinishTime = model.establishFinishTime();
                            view.labelSetFinishTime(estimateFinishTime);
                            view.UIUpdate();
                            randTime = new Random();
                            for (int i = 0; i < quantity; i++)
                            {
                                if (model.getEmergencyStatus())
                                {
                                    break;
                                }
                                int delaySynth = 1500 + randTime.nextInt(1000);
                                model.randomCords();
                                robot.mouseMove(model.getMouseCordsXIntRand(), model.getMouseCordsYIntRand());
                                int click = InputEvent.BUTTON1_DOWN_MASK;
                                int clickDelay = 200 + (randTime.nextInt(100) -30);
                                robot.mousePress(click);
                                robot.delay(clickDelay);
                                robot.mouseRelease(click);
                                robot.delay(delaySynth);
                                int buttonDelay = 200 + (randTime.nextInt(70) - 30);
                                pressMacroRobot1(robot, model.getButton1(), buttonDelay);
                                int macroDone = model.getTimeMillisec() + 2000 + randTime.nextInt(2000);
                                robot.delay(macroDone);
                            }
                            view.labelSetFinishTime(estimateFinishTime + " |finished at " + model.getTimeNow());
                            break;
                        case 2:
                            int quantity2 = model.getQuantity();
                            String estimateFinishTime2 = model.establishFinishTime2();
                            view.labelSetFinishTime(estimateFinishTime2);
                            view.UIUpdate();
                            randTime = new Random();
                            for (int i = 0; i < quantity2; i++)
                            {
                                if (model.getEmergencyStatus())
                                {
                                    break;
                                }
                                int delaySynth = 1500 + randTime.nextInt(1000);
                                model.randomCords();
                                robot.mouseMove(model.getMouseCordsXIntRand(), model.getMouseCordsYIntRand());
                                int click = InputEvent.BUTTON1_DOWN_MASK;
                                int clickDelay = 200 + (randTime.nextInt(100) -30);
                                robot.mousePress(click);
                                robot.delay(clickDelay);
                                robot.mouseRelease(click);
                                robot.delay(delaySynth);
                                int buttonDelay = 200 + (randTime.nextInt(70) -30);
                                pressMacroRobot1(robot, model.getButton1(), buttonDelay);
                                if (model.getEmergencyStatus())
                                {
                                    break;
                                }
                                int macro1Done = model.getMacro1TimeMillisec() + 1000 + randTime.nextInt(500);
                                robot.delay(macro1Done);
                                buttonDelay = 200 + (randTime.nextInt(70) - 30);
                                pressMacroRobot2(robot, model.getButton2(), buttonDelay);
                                int macro2Done = (model.getTimeMillisec() - model.getMacro1TimeMillisec()) + 2000 + randTime.nextInt(2000);
                                robot.delay(macro2Done);
                            }

                            view.labelSetFinishTime(estimateFinishTime2 + " |finished at " + model.getTimeNow());
                            break;
                        case 3:
                            view.labelSetFinishTime("No coords for synthesis");
                            model.setReset(true);
                            break;

                        default:
                            view.labelSetFinishTime("Unknown problem");
                            model.setReset(true);
                            break;
                    }

                    model.setCraftingStatus(false);
                    model.stopKeepRunning();
                    model.setReset(true);

                } catch (AWTException e1)
                {
                    e1.printStackTrace();
                }

            }

        }

    }

    // to run additional thread for crafting and bind it to button
    class CraftingAL implements ActionListener
    {
        CraftingConcurrency craftingConcurrency = null;

        @Override
        public void actionPerformed(ActionEvent e)
        {
            Thread t;

            if (model.getReset())
            {
                model.stopKeepRunning();
                craftingConcurrency = null;
                model.startKeepRunning();
                model.setReset(false);
            }

            if (model.getEmergencyStatus())
            {
                model.stopKeepRunning();
            }

            if (craftingConcurrency == null)
            {
                craftingConcurrency = new CraftingConcurrency();
                t = new Thread(craftingConcurrency);
                t.start();
            }

        }
    }


    class EmergencyExitAL implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            model.setEmergencyStatus(true);
            if (model.getCraftingStatus())
            {
                System.exit(0);
            } else
            {
                System.exit(1);
            }
            view.dispatchEvent(new WindowEvent(view, WindowEvent.WINDOW_CLOSING));
            System.exit(1);

        }

    }

    class AboutAL implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            JFrame about = new About();
            about.setVisible(true);
        }

    }

    class ResetAL implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (!model.getCraftingStatus() && !model.getEmergencyStatus() && !model.getReset()) {
                view.textSetKey1("");
                view.textSetKey2("");
                view.UIUpdate();
            }

        }

    }

    public void pressMacroRobot1(Robot r, String button, int delay)
    {
        try
        {
            String code = "VK_" + button.charAt(0);
            Field f = KeyEvent.class.getField(code);
            int keyEvent = f.getInt(null);

            if (model.getShift1())
            {
                r.keyPress(KeyEvent.VK_SHIFT);
            }
            if (model.getCtrl1())
            {
                r.keyPress(KeyEvent.VK_CONTROL);
            }
            if (model.getAlt1())
            {
                r.keyPress(KeyEvent.VK_ALT);
            }

            r.delay(delay);
            r.keyPress(keyEvent);

            if (model.getShift1())
            {
                r.keyRelease(KeyEvent.VK_SHIFT);
            }
            if (model.getCtrl1())
            {
                r.keyRelease(KeyEvent.VK_CONTROL);
            }
            if (model.getAlt1())
            {
                r.keyRelease(KeyEvent.VK_ALT);
            }
            r.keyRelease(keyEvent);

        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e)
        {
            e.printStackTrace();
        }

    }

    public void pressMacroRobot2(Robot r, String button, int delay)
    {
        try
        {
            String code = "VK_" + button.charAt(0);
            Field f = KeyEvent.class.getField(code);
            int keyEvent = f.getInt(null);

            if (model.getShift2())
            {
                r.keyPress(KeyEvent.VK_SHIFT);
            }
            if (model.getCtrl2())
            {
                r.keyPress(KeyEvent.VK_CONTROL);
            }
            if (model.getAlt2())
            {
                r.keyPress(KeyEvent.VK_ALT);
            }

            r.delay(delay);
            r.keyPress(keyEvent);

            if (model.getShift2())
            {
                r.keyRelease(KeyEvent.VK_SHIFT);
            }
            if (model.getCtrl2())
            {
                r.keyRelease(KeyEvent.VK_CONTROL);
            }
            if (model.getAlt2())
            {
                r.keyRelease(KeyEvent.VK_ALT);
            }
            r.keyRelease(keyEvent);

        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e)
        {
            e.printStackTrace();
        }

    }


}
