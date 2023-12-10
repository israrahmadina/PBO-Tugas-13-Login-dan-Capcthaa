import java.util.Random;
import java.util.Scanner;

public class app {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Login
        while (true) {
            try {
                System.out.print("Masukkan username: ");
                String username = scanner.nextLine();
                System.out.print("Masukkan password: ");
                String password = scanner.nextLine();

                // Validate username and password
                if (username.equals("israDina") && password.equals("isra2324")) {
                    System.out.println("Login berhasil!");
                    break;
                } else {
                    throw new LoginException("Username atau password salah!");
                }
            } catch (LoginException e) {
                System.out.println(e.getMessage());
            }
        }

        // Loop until the captcha is correct
        while (true) {
            // Generate random captcha
            String captcha = generateCaptcha(random);

            // Display captcha and ask for input
            System.out.print("Masukkan captcha: " + captcha + " : ");
            String inputCaptcha = scanner.nextLine();

            if (inputCaptcha.equals(captcha)) {
                System.out.println("Captcha benar!");
                break;
            } else {
                System.out.println("Captcha salah! Silakan coba lagi.");
            }
        }

        // Process purchase
        System.out.print("Masukkan No Faktur: ");
        String noFaktur = scanner.nextLine();

        System.out.print("Masukkan Kode Barang: ");
        String kodeBarang = scanner.nextLine();

        System.out.print("Masukkan Nama Pembeli: ");
        String namaPembeli = scanner.nextLine();

        System.out.print("Masukkan noHp : ");
        String noHp = scanner.nextLine();

        System.out.print("Masukkan Alamat Pelanggan: ");
        String alamatPelanggan = scanner.nextLine();

        System.out.print("Masukkan Nama Produk yang akan dibeli: ");
        String namaProduk = scanner.nextLine();

        System.out.print("Masukkan Harga Produk yang dibeli: ");
        double hargaProduk = scanner.nextDouble();

        System.out.print("Masukkan Jumlah Barang yang diBeli: ");
        int jumlahBeli = scanner.nextInt();

        // Membuat objek dari kelas PembelianBarang
        pembelianProduk pembelian = new pembelianProduk(noFaktur,kodeBarang, namaPembeli, noHp,alamatPelanggan, namaProduk, hargaProduk, jumlahBeli);

        // Menampilkan informasi pembelian
        pembelian.tampilkanInfo();
    }

     // Function to generate random captcha
    private static String generateCaptcha(Random random) {
        String captcha = "";
        for (int i = 0; i < 6; i++) {
            int randomInt = random.nextInt(36);
            char character = (char) (randomInt < 10 ? 48 + randomInt : 55 + randomInt);
            captcha += character;
        }
        return captcha;
    }

    // Custom exception class
    static class LoginException extends Exception {
        public LoginException(String message) {
            super(message);
        }
    }
}