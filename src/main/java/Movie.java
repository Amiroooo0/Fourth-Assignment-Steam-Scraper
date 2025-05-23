public class Movie {
    private final String title;
    private final int nominations;
    private final int awards;

    public Movie(String title, int nominations, int awards) {
        this.title = title;
        this.nominations = nominations;
        this.awards = awards;
    }

    public int getAwards() {
        return awards;
    }

    public int getNominations() {
        return nominations;
    }

    public String getTitle() {
        return title;
    }

    public String toString() {
        return "title : " + title + "\nnominations : " + nominations + "\nawards : " + awards;
    }


}
