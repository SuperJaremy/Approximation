import approximation.Approximation;
import approximation.Approximations;
import io.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Input in;
        System.out.println("Откуда будет производится ввод? [f]ile/[c]onsole");
        Scanner input  = new Scanner(System.in);
        String str = input.next().trim();
        if(str.equals("f"))
            in = new FileInput();
        else if(str.equals("c"))
            in = new ConsoleInput();
        else{
            System.out.println("Ошибка выбора!");
            return;
        }
        Input.Table table = in.read();
        List<Approximation> approximations = new ArrayList<>();
        for(Approximations i: Approximations.values()){
            approximations.add(i.solve(table));
        }
        Approximation bestApproximation = approximations.stream().filter(x->!Double.valueOf(x.getRSq()).isNaN())
                .max(Comparator.comparingDouble(Approximation::getRSq)).get();
        ChartDrawer drawer = new ChartDrawer(table.getX(), table.getY(), bestApproximation);
        Output out = new ConsoleOutput(bestApproximation);
        out.write();
        System.out.println("Сохранить результат в файл? [y]es/[n]o");
        str = input.next().trim();
        if(str.equals("y")){
            out = new FileOutput(bestApproximation);
            out.write();
        }
    }
}
