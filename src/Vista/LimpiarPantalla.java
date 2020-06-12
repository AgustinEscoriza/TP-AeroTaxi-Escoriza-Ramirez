package Vista;

public class LimpiarPantalla {

    public LimpiarPantalla(){

    }

    public void limpiarPantalla(){
        try
        {
            String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (Exception exception)
        {
            // capturar error
        }
    }
}
