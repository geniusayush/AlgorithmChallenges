package BowlingAlley;

public class StandardRule implements Rule {
    @Override
    public Result getScore( char hitValue, Game game) throws Exception {
        Result result;
        if (game.throwNumber > 1) throw new Exception("wrong input");
        if (game.throwNumber == 0) {
            if (hitValue == 88) result = new Result(20, 1,10);
            else if (hitValue<='9' && hitValue>='0') result = new Result(hitValue-48, 0,10-(hitValue-48));

            else throw new Exception("wrong hitvalue");
        } else {
            if (hitValue == 47) result = new Result(game.getPinsLeft() + 5, 1,10);
            else if (hitValue-'0' < game.getPinsLeft()) result = new Result(hitValue-48, 1,10);

            else throw new Exception("wrong hitvalue");
        }
        return result;
    }
}
