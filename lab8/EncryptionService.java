import java.util.Base64;

interface EncryptionStrategy{
    public String encrypt(String text);
}

class XOREncryption implements EncryptionStrategy {
    private char key;

    public XOREncryption(char key){
        this.key = key;
    }

    @Override
    public String encrypt(String text) {
        StringBuilder res = new StringBuilder();
        for (char ch : text.toCharArray()) {
            res.append((char) (ch ^ key));
        }
        return res.toString();
    }
}

class CaesarCipherEncryption implements EncryptionStrategy{
    private int shift;

    public CaesarCipherEncryption(int shift){
        this.shift = shift;
    }

    @Override
    public String encrypt(String text) {
        StringBuilder res = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                ch = (char) ((ch - base + shift) % 26 + base);
            }
            res.append(ch);
        }
        return res.toString();
    }
}

class Base64Encryption implements EncryptionStrategy{
    @Override
    public String encrypt(String text){
        return Base64.getEncoder().encodeToString(text.getBytes());
    }
}

class ReverseStringEncryption implements EncryptionStrategy{
    @Override
    public String encrypt(String text){
        StringBuilder res = new StringBuilder();
        res.append(text);
        res.reverse();
        return res.toString();
    }
}

class DuplicateCharacterEncryption implements EncryptionStrategy{
    @Override
    public String encrypt(String text) {
        StringBuilder res = new StringBuilder();
        for (char ch : text.toCharArray()){
            res.append(ch);
            res.append(ch);
        }
        return res.toString();
    }
}

class EncryptionService {
    private EncryptionStrategy currentStrategy;

    public void setEncryptionStrategy(EncryptionStrategy strategy){
        this.currentStrategy = strategy;
    }

    public String encrypt(String text){
        return this.currentStrategy.encrypt(text);
    }
}