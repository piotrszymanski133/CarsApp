package stud.sem5.aui.lab.lab1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import stud.sem5.aui.lab.lab1.entity.CarBrand;
import stud.sem5.aui.lab.lab1.services.CarBrandService;
import stud.sem5.aui.lab.lab1.services.CarModelService;
import java.util.Optional;
import java.util.Scanner;

@Component
public class CommandLine implements CommandLineRunner {

    private CarModelService modelService;
    private CarBrandService brandService;

    @Autowired
    public CommandLine(CarBrandService carBrandService, CarModelService carModelService){
        this.brandService = carBrandService;
        this.modelService = carModelService;
    }

    @Override
    public void run(String... args) throws Exception {
        brandService.findAll().forEach(System.out::println);
        modelService.findAll().forEach(System.out::println);

        System.out.println("Available commands:");
        System.out.println("lb - List all car brands names");
        System.out.println("lm - List all car models names");
        System.out.println("am brand_name model_name price generation - Add new model");
        System.out.println("dm model_id - Delete model");
        System.out.println("q - Exit application");
        Scanner scanner = new Scanner(System.in);
        String input;
        Integer id = 6;
        int price, generation;

        while(true)
        {
            input = "";
            if (scanner.hasNext()) {
                input = scanner.nextLine();
            }

            if(input.equals("q")){
                System.exit(0);
            }

            else if(input.equals("lb")){
                brandService.findAll().forEach(System.out::println);
            }

            else if(input.equals("lm")){
                modelService.findAll().forEach(System.out::println);
            }

            else if(input.equals("dm")){
                System.out.println("Type model id");
                final String tmp = scanner.nextLine();
                Integer deleteId = Integer.valueOf(tmp);
                modelService.delete(deleteId);
            }

            else if(input.equals("am")){
                System.out.println("Type brand name");
                String newBrand = scanner.nextLine();
                CarBrand c;
                Optional<CarBrand> newCarBrand = brandService.find(newBrand);
                if(newCarBrand.isEmpty()) {
                    System.err.println("Brand " + newBrand + " does not exist");
                    continue;
                }
                c = newCarBrand.get();

                System.out.println("Type model name");
                String newModel = scanner.nextLine();

                System.out.println("Type model price");
                String pr = scanner.nextLine();
                price = Integer.parseInt(pr);

                System.out.println("Type model generation");
                String gen = scanner.nextLine();
                generation = Integer.parseInt(gen);

                modelService.createNewModel(c, newModel, price, generation, id);
                id++;
            }

        }
    }
}
