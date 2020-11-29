import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Ejercicio4 {
    public void ejer4(File file) {
        try {
            divideTextCharacteres(file);
        } catch (Exception e) {
            System.out.println("Error de lectura de fichero");
        }
    }

    public static void divideTextCharacteres(File file) throws Exception {
        ArrayList<CharacterAll> characterAll = new ArrayList<>();
        try (FileReader fileRead = new FileReader(file)) {
            int i;
            int num = 0;
            boolean flag = true;
            boolean firstCharacter = true;
            // char[] buffer = new char[50];
            while ((i = fileRead.read()) != -1) {
                // System.out.print(new String(buffer,0,1)); probar con buffer luego
                if (firstCharacter) {
                    characterAll.add(new CharacterAll((char) i, 1));
                    firstCharacter = false;
                } else {
                    for (int j = 0; j < characterAll.size(); j++) {
                        if (characterAll.get(j).getCharacter() == i) {
                            num = characterAll.get(j).getNum();
                            num = num + 1;
                            characterAll.get(j).setNum(num);
                            flag = false;
                        }
                    }
                    if (flag) {
                        characterAll.add(new CharacterAll((char) i, 1));
                        flag = true;
                        break;//Va aqui el break para que no busque más si encuentra la letra?
                    }
                }
            }
        }
        for (CharacterAll characterAll2 : characterAll) {
            System.out.println(characterAll2.getNum());
            System.out.println(characterAll2.getCharacter());
        }
        theMoreAppearCharacter(characterAll);
    }

    public static void theMoreAppearCharacter(ArrayList<CharacterAll> characterAll) {
        char characterProvisional = characterAll.get(0).getCharacter();
        int numMax = characterAll.get(0).getNum();
        for (CharacterAll character : characterAll) {
            //System.out.println("entro for");
            if ((character.getNum()) > numMax) {
                //System.out.println("entro if");
                numMax = character.getNum();
                characterProvisional = character.getCharacter();
            }
        }
        System.out.printf("El caracter que más aparece es %c, un número total de %d veces", characterProvisional,
                numMax);
    }

}
