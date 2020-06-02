package Questions;

import java.util.Arrays;

public class Theme {

    private String[] themes;
    private int indicateur = -1;

    public Theme(String[] themes) {
        this.themes = themes;
    }

    @Override
    public String toString() {
        return "Theme{" +
                "themes=" + Arrays.toString(themes) +
                ", indicateur=" + indicateur +
                '}';
    }
}

// TODO: SelectionnerTheme - SelectionnerCinqTheme - Afficher