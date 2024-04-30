import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.*;

public class Consulta {
    private LocalDate data;
    private LocalTime horario;
    private int crm;
    private String cpf;

    public Consulta(LocalDate data, LocalTime horario, int crm, String cpf) {
        this.data = data;
        this.horario = horario;
        this.crm = crm;
        this.cpf = cpf;
    }

    
}
