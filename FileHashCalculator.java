import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;

public class FileHashCalculator {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java FileHashCalculator <file_path>");
            return;
        }

        String filePath = args[0];

        try {
            //Ele cria uma instância MessageDigest usando o algoritmo SHA-256.
            MessageDigest md = MessageDigest.getInstance("MD5");

            //Ele abre um FileInputStream para ler o arquivo especificado pelo caminho do arquivo.
            FileInputStream fis = new FileInputStream(filePath);

            //Ele envolve FileInputStream com DigestInputStream para 
            //que possa calcular o hash durante a leitura do arquivo.
            DigestInputStream dis = new DigestInputStream(fis, md);

            //Ele define um buffer para ler o arquivo em pedaços. Neste caso,
            // é utilizado um tamanho de buffer de 8.192 bytes. Você pode ajustar o tamanho
            // do buffer conforme necessário para otimizar seu caso de uso específico.
            byte[] buffer = new byte[8192]; 


            //Ele entra em um loop para ler o arquivo em partes
            // e atualizar o hash digest usando a instância MessageDigest.
            while (dis.read(buffer) != -1) {
                // Read the file in chunks and update the digest
            }
            //Depois que todo o arquivo for processado, ele fecha o DigestInputStream.
            dis.close();

            //Ele obtém o valor final do hash como uma matriz de bytes usando md.digest().
            byte[] hash = md.digest();

            //javac FileHashCalculator.java atualizar a funcao
            // Ele converte a matriz de bytes em uma string hexadecimal,
            // que é uma forma comum de representar valores hash.
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }

            System.out.println("SHA-256 Hash do " + filePath + ": " + hexString.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
