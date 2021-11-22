public class App
{

    public static void main(String[] args)
    {
        Model model = new Model();
        UIMain view = new UIMain();
        Controller c = new Controller(model,view);
        view.setVisible(true);

    }

}
