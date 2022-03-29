package BowlingAlley;

public interface Rule
{
    public Result getScore(char hitValue,Game game) throws Exception;
}
