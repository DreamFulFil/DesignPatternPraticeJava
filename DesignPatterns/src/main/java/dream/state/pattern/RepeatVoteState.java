package dream.state.pattern;

public class RepeatVoteState implements VoteState{
	@Override
	public void vote(String user, String voteItem, VoteManager voteManager) {
		System.out.println("�Ф��n���Ч벼�I");
		if(voteManager.getMapVoteCount().get(user) >= 4){
			voteManager.getMapState().put(user, new SpiteVoteState());
		}
	}
}
