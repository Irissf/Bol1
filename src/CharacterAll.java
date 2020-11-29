public class CharacterAll {
    private int num;
    private char character;

    public CharacterAll(char character, int num) {
        setNum(num);
        setCharacter(character);
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    // @Override
    // public boolean equals(Object obj) {
    //     CharacterAll m = (CharacterAll) obj;
    //     return this.character == m.getCharacter();
    
    // }

    // @Override
    // public String toString() {
    //     // TODO Auto-generated method stub
    //     return super.toString();
    // }
}
