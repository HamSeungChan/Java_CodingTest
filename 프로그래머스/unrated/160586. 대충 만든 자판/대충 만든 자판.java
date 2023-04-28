class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        for (int i = 0; i < targets.length; i++) {
            int targetClickCount = 0;
            char[] characters = targets[i].toCharArray();
            for (char character : characters) {
                int oneTarget = findKeymap(keymap, character);
                if (oneTarget == Integer.MAX_VALUE) {
                    targetClickCount = -1;
                    break;
                } else {
                    targetClickCount += oneTarget;
                }
            }
            answer[i] = targetClickCount;
        }
        return answer;
    }

    public int findKeymap(String[] keymaps, char character) {
        int findCharacterCount = Integer.MAX_VALUE;
        for (String keymap : keymaps) {
            for (int i = 0; i < keymap.length(); i++) {
                if (keymap.charAt(i) == character) {
                    findCharacterCount = Math.min(findCharacterCount, i + 1);
                }
            }
        }
        return findCharacterCount;
    }
}