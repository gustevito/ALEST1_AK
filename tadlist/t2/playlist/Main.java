import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);

        Playlist playlist = new Playlist();
        System.out.println("-- PLAYLIST --");
        playlist.addSong("Killing In The Name");
        playlist.listSongs();

        while (true) {
            exibirMenu();

            int cod = t.nextInt();
            t.nextLine();
            switch (cod) {
                case 1:
                    System.out.println("Digite o nome da música: ");
                    String musica = t.nextLine();

                    playlist.addSong(musica);
                    System.out.println("'" + musica + "'" + " adicionada!");
                    break;

                case 2:
                    System.out.println("Digite o nome da música para remover: ");
                    musica = t.nextLine();

                    playlist.removeSong(musica);
                    System.out.println("'" + musica + "'" + " removida!");
                    break;
                case 3:
                    playlist.listSongs();
                    break;
                case 4:
                    t.close();
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }

    }

    private static void exibirMenu() {
        System.out.println("\n-- MENU --");
        System.out.println("Selecione uma opção: ");
        System.out.println("1. Adicionar uma música");
        System.out.println("2. Remover uma música");
        System.out.println("3. Listar as músicas");
        System.out.println("4. Sair");

    }
}