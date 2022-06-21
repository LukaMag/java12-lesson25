package CLASSWORK25;

public enum Game {
    ROCK("Rock",1){
        @Override
        public int winnerIs(Game rasping) throws NullPointerException {
            int point = 0;
            if(rasping == PAPER){
                point = -1;
            }if(rasping == SCISSORS){
                point = 1;
            }if(rasping == ROCK){
            }
            return point;
        }
    },
    PAPER("Paper",2){
        @Override
        public int winnerIs(Game rasping)throws NullPointerException {
            int point = 0;
            if(rasping == SCISSORS){
                point = -1;
            }if(rasping == ROCK){
                point = 1;
            }if(rasping == PAPER){
            }
            return point;
        }
    },
    SCISSORS("Scissors",3){
        @Override
        public int winnerIs(Game rasping)throws NullPointerException {
            int point = 0;
            if(rasping == SCISSORS){
            }if(rasping == ROCK){
                point = -1;
            }if(rasping == PAPER){
                point = 1;
            }
            return point;
        }
    };

    private String name;
    private int id;

    Game(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
    public int winnerIs(Game rasping) throws NullPointerException{
        return 0;
    };
}
