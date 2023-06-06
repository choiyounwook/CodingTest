class Solution {
    public int solution(String skill, String[] skill_trees) {
   
		/**
		 * 스킬트리
		 * 
		 * skill : 선행 스킬 순서
		 * skill_trees : 유저들이 만든 스킬트리1를 담은 배열
		 * 
		 * */
		int answer = 0;
		
		for (int i = 0; i < skill_trees.length; i++) {
			int idx = 0;
			boolean flag = true;
			for (int j = 0; j < skill.length(); j++) {
				int tmp =skill_trees[i].lastIndexOf(skill.charAt(j)+"");
				if(tmp!=-1&&idx>tmp)
				{
					flag = false;
					break;
				}if(idx==-1&&tmp!=-1)
				{
					flag = false;
					break;
				}
				idx = tmp;
			}
			
			if(flag) answer++;
		}
        return answer;
    }
}