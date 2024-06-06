public abstract class ObjetoMovel {
    private double largura; // em centímetros
    private double altura; // em centímetros
    private double x = 0; // coordenada x atual do objeto, em centímetros
    private double y = 0; // coordenada y atual do objeto, em centímetros
    private double x_max = 0; // valor máximo de x
    private double y_max = 0; // valor máximo de y
    public ObjetoMovel(double largura, double altura)
    {
        assert( largura > 0 && altura > 0 );
        this.largura = largura;
        this.altura = altura;
    }
    public void definir_territorio(double x_limite, double y_limite)
    {
        assert( x_limite >= 0 && y_limite >= 0 );
        this.x_max = x_limite - largura;
        this.y_max = y_limite - altura;
        assert( this.x_max >= 0 && this.y_max >= 0 );
    }
    public String localizacao() { return "(" + x + ", " + y + ')'; }
    abstract protected double deslocamento_por_segundo(); // em centímetros
    public void mover(double delta_x, double delta_y)
    {
        mover_horizontal(delta_x);
        mover_vertical(delta_y);
    }
    private void mover_horizontal(double delta_x)
    {
        double novo_x = x + delta_x;
        if (novo_x > x_max) novo_x = x_max;
        else if (novo_x < 0) novo_x = 0;

        int sentido = 0;
        if (novo_x > x) sentido = 1;
        else sentido = -1;
        while (x != novo_x)
        {
            // calcula e imprime a localização do objeto a cada segundo
            double resultado = Math.abs(x - novo_x);
            if (resultado < deslocamento_por_segundo())
                x = novo_x;
            else
                x = x + sentido * deslocamento_por_segundo();
            Timer.aguardar(1); // aguarda um segundo
            System.out.println(Timer.tempo() + localizacao());
        }
    }
    private void mover_vertical(double delta_y)
    {
        double novo_y = y + delta_y;
        if (novo_y > y_max) novo_y = y_max;
        else if (novo_y < 0) novo_y = 0;
        int sentido = 0;
        if (novo_y > y) sentido = 1;
        else sentido = -1;
        while (y != novo_y)
        {
            // calcula e imprime a localização do objeto a cada segundo
            if (Math.abs(y - novo_y) < deslocamento_por_segundo())
                y = novo_y;
            else
                y = y + sentido * deslocamento_por_segundo();
            Timer.aguardar(1); // aguarda um segundo
            System.out.println(Timer.tempo() + localizacao());
        }
    }
}