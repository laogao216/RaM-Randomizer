import java.awt.Desktop;
import java.net.URI;

/**
 * This class is the driver application of the randomizer, parts of it needs to be customized for it
 * to work on other shows
 * 
 * @author laogao216
 */
public class Driver {

  /**
   * Holds the number of episodes in each season, in order, starts at index 0 for season 1, in an
   * int Array, which needs to be customized to work on other shows
   */
  private static int[] NumOfEpisodeInSeason = new int[] {11, 10, 10, 5};

  /**
   * Prints to console a random episode and opens a browser page that contains the video file.
   * Find a streaming site and customize the URL convention here for other shows to work
   */
  public static void main(String[] args) {
    Randomizer RaM = new Randomizer(NumOfEpisodeInSeason);
    String s = RaM.random();
    System.out.println(s);
    Integer season = Character.getNumericValue(s.charAt(1));
    Integer episode = Character.getNumericValue(s.charAt(3));
    try {
      Desktop desktop = java.awt.Desktop.getDesktop();
      URI url = new URI("https://kisscartoon.info/episode/rick-and-morty-season-"
          + season.toString() + "-episode-" + episode.toString() + "/?server=rapidvideo");
      desktop.browse(url);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
