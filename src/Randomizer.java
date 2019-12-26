import java.util.Random;

/**
 * This class holds the number of episode in each season, it works on any show
 * 
 * @author laogao216
 */
public class Randomizer {

  /**
   * Holds the number of seasons in the show, season 0 reserved for special episodes does not count
   */
  private int numOfSeasons;

  /**
   * Holds the number of episodes in each season, index number is season number, index 0 is reserved
   * for special episodes
   */
  private int[] numOfEpisodeInSeason;

  /**
   * Constructs a new Randomizer
   * 
   * @param numOfEpisodeInSeason - int Array of the number of episodes in each season in order
   */
  public Randomizer(int[] numOfEpisodeInSeason) {
    this.numOfSeasons = numOfEpisodeInSeason.length;
    this.numOfEpisodeInSeason = new int[numOfSeasons + 1];
    this.numOfEpisodeInSeason[0] = 0;
    for (int season = 1; season <= numOfSeasons; season++) {
      this.numOfEpisodeInSeason[season] = numOfEpisodeInSeason[season - 1];
    }
  }

  /**
   * Accesses the numOfSeasons
   * 
   * @return numOfSeasons - in the show
   */
  public int getNumOfSeasons() {
    return numOfSeasons;
  }

  /**
   * Accesses the numOfEpisodeInSeason
   * 
   * @param season - which contains this amount of episodes
   * @return number of episodes in the season
   */
  public int getNumOfEpisodeInSeason(int season) {
    return numOfEpisodeInSeason[season];
  }

  /**
   * Sets the number of seasons in the show, this will overwrite all stored data in this class
   * 
   * @param numOfSeason - in the show
   */
  public void setNumOfSeasons(int numOfSeasons) {
    this.numOfSeasons = numOfSeasons;
    numOfEpisodeInSeason = new int[numOfSeasons + 1];
  }

  /**
   * Sets the number of episodes in the season
   * 
   * @param season       - which have numOfEpisode
   * @param numOfEpisode - in the season
   */
  public void setNumOfEpisodeInSeason(int season, int numOfEpisode) {
    numOfEpisodeInSeason[season] = numOfEpisode;
  }

  /**
   * Randomize season and randomize episode based on season selection
   * 
   * @return season and episode chosen, in the format of S_E_ stored in a String
   */
  public String random() {
    Random random = new Random();
    Integer season = random.nextInt() % numOfSeasons;
    if (season < 1) {
      season += numOfSeasons;
    }
    Integer episode = random.nextInt() % numOfEpisodeInSeason[season];
    if (episode < 1) {
      episode += numOfEpisodeInSeason[season];
    }
    return "S" + season + "E" + episode;
  }

}
