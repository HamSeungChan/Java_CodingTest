import java.util.*;

// 1. 장르별 재생 횟수
// 2. 장르별로 저장하는 list, index와 횟수를 저장해야한다.

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, Integer> genresCount = new HashMap<>();
        Map<String, List<Music>> musicMap = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++){
            String genre = genres[i];
            
            // 장르별 총 플레이 횟수 
            genresCount.put(genre, genresCount.
                            getOrDefault(genre, 0) + plays[i]);
            
            // 장르별 음악을 저장
            if(!musicMap.containsKey(genre)){
                musicMap.put(genre, new ArrayList<>());
            }
            
            List<Music> list = musicMap.get(genre);
            list.add(new Music(i, plays[i]));
        }
        
        List<String> keyList = new ArrayList<>(genresCount.keySet());
        keyList.sort(new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                return genresCount.get(o2) - genresCount.get(o1);
            }
        });
        
        List<Integer> answer = new ArrayList<>();
        for(String key : keyList){
            
            List<Music> music = musicMap.get(key);
             if(music.size() < 2){
                answer.add(music.get(0).index);
                continue;
            }
            
            Collections.sort(music, new Comparator<Music>(){
               @Override
                public int compare(Music o1, Music o2){
                    if(o1.playCount == o2.playCount){
                        return o1.index - o2.index;
                    }
                    
                    return o2.playCount - o1.playCount;
                }
            });
            
            answer.add(music.get(0).index);
            answer.add(music.get(1).index);
        }
        
        int [] answerArray = new int[answer.size()];
        for(int i = 0; i < answer.size();i++){
            answerArray[i] = answer.get(i);
        }
        
        return answerArray;
    }
}

class Music{
    int index;
    int playCount;
    
    public Music(int index, int playCount){
        this.index = index;
        this.playCount = playCount;
    }
}