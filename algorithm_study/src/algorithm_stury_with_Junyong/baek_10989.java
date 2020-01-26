package algorithm_stury_with_Junyong;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class baek_10989 {

	public static void main(String[] args) throws IOException {
		// 수 정렬하기 3
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//출력문을 생성할 수 있다.
		//BufferedWriter은 기본 크기를 가지는 출력 버퍼로 버퍼링 된 문자형 출력 스트림 (character output stream) 객체를 만든다.
		int n = Integer.parseInt(br.readLine());//n의 범위 1~10,000,000  수는 1~10,000의 자연수
		int[] arr = new int[10001];//수가 1만이기 때문에 배열을 10001의 크기로 만들어준다
		for(int i=0;i<n;i++) {
			int t=Integer.parseInt(br.readLine());
			arr[t]++;//입력받은 값(1~10000)을 배열 위치에 넣는다.
		}
		
		for(int i=1;i<10001;i++) {//배열을 처음부터 끝까지 for문
			for(int j=0;j<arr[i];j++) {//값이 들어있으면 arr[i]이 0보다 큰 값이 들어있기 때문에 중복으로 들어있더라도 출력을 뽑을 수 있다.
				bw.write(String.valueOf(i));//출력문을 쓰기위한 write 
				bw.newLine();//라인을 바꿔주는  것.
			}
		}
		//flush()는 전송이 끝나고 나서 해주면 됩니다. 당연히 xxx.close()하기전에 해줘야 하겠지요. 
		//flush는 쉽게 말해서 stream에 남아 있는 데이터를 강제로 내보내는 역할을 합니다.
		//예를 들어 호스가 연결된 수도꼭지를 틀고 나서 잠그면 호스안에 물이 조금 남아 있게 됩니다.
		//그 남아 있는 물을 빼내기 위해서 호스를 들어 올려서 빼는 경우를 보셨을 겁니다.
		//flush()는 호스에 고인 물을 빼내는 역할을 합니다.
		bw.flush();
		bw.close();//close()는 자동으로 flush()를 호출합니다.
	}

}
