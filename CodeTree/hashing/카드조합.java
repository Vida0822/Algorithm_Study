import java.util.*; 

class Solution {
    public String[] solution(String[] cards, String[] words) {
        // 카드별 문자 빈도수 저장
        ArrayList<HashMap<String, Integer>> list = new ArrayList<>();

        for (String card : cards) {
            HashMap<String, Integer> map = new HashMap<>();
            for (char c : card.toCharArray()) {
                String key = String.valueOf(c);
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            list.add(map);
        }

        // 가능한 단어 찾기
        ArrayList<String> answer = new ArrayList<>();

        for (String word : words) {
            // 리스트 복사 (각 카드의 문자 빈도수 유지)
            ArrayList<HashMap<String, Integer>> copy = new ArrayList<>(list.size());
            for (HashMap<String, Integer> originalMap : list) {
                copy.add(new HashMap<>(originalMap));
            }

            boolean[] usedCard = new boolean[copy.size()];
            boolean isValidWord = true;

            for (char c : word.toCharArray()) {
                String key = String.valueOf(c);
                boolean found = false;

                // 각 카드에서 문자 찾기
                for (int j = 0; j < copy.size(); j++) {
                    HashMap<String, Integer> map = copy.get(j);
                    if (map.containsKey(key) && map.get(key) > 0) {
                        // 문자 사용 처리
                        map.put(key, map.get(key) - 1);
                        if (map.get(key) == 0) {
                            map.remove(key);
                        }
                        usedCard[j] = true;
                        found = true;
                        break; // 한 줄에서 하나의 문자만 사용 가능하므로 다음 문자로 이동
                    }
                }

                if (!found) {
                    isValidWord = false;
                    break;
                }
            }

            // 모든 줄에서 최소 1개 이상 사용했는지 확인
            for (boolean used : usedCard) {
                if (!used) {
                    isValidWord = false;
                    break;
                }
            }

            if (isValidWord) {
                answer.add(word);
            }
        }

        return answer.isEmpty() ? new String[]{"-1"} : answer.toArray(new String[0]);
    }
}
