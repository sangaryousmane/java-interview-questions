package professional;


public class Team {
    private Member member;

    public Team(Member member){
        this.member = member;
    }

    @Override
    public String toString() {
        return "Basics{" +
                "member=" + member +
                '}';
    }

    public static void main(String[] args) {
        Member ronaldo = new Member("Ronaldo", "Striker",
                20, 1);
        Team basics=new Team(ronaldo);
        System.out.println(basics);
    }

}

class Member{
    private String name;
    private String type;
    private int level;
    private int rank;

    public Member(String name, String type, int level, int rank){
        this.name=name;
        this.type =type;
        this.level = level;
        this.rank = rank;
    }

    public String getName() throws Exception {
        if (name.length() >= 20)
            throw new Exception("Name too long.");
        else
            return name;
    }

    public void setName(String name) {
        if (name != null && name.length() > 2)
            this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", level=" + level +
                ", rank=" + rank +
                '}';
    }
}

class CountHolder {
    private int count = 0;
    public synchronized int getCount() {
        return count;
    }
    public synchronized void setCount(int c) { count = c; }
}
