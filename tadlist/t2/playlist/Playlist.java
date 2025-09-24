public class Playlist {
    private final LinkedListOfString list;

    public Playlist() {
        list = new LinkedListOfString();
    }

    public void addSong(String som) {
        this.list.add(som);
    }

    public LinkedListOfString removeSong(String name) {
        this.list.remove(name);
        return this.list;
    }

    public void listSongs() {
        System.out.println(list);
    }
}
