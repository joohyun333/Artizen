package artizens;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import artizens.domain.ArtWork;
import artizens.domain.ArtWorkCategory;
import artizens.domain.Collaboration;
import artizens.domain.CollaborationArtWork;
import artizens.domain.Creator;
import artizens.domain.Patron;
import artizens.domain.PatronImages;
import artizens.domain.Reward;
import artizens.domain.RewardCategory;
import artizens.domain.UploadFile;
import artizens.domain.UserProfile;

@Component
public class initDb {

	private final InitService initService;

	public initDb(InitService initService) {
		this.initService = initService;
	}

	/**
	 * 빈설정이 완료되면 @PostConstruct의 빈이 실행됨. initService.dbInit1() 가 실행되서 dbinit1()이
	 * 실행(db에 값이 넣어짐)
	 */
	@PostConstruct
	public void init() {
		initService.dbInit1();
	}

	@Component
	@Transactional
	static class InitService {

		private final EntityManager em;

		public InitService(EntityManager em) {
			this.em = em;
		}

		public void dbInit1() {
			/**
			 * user - admin 
			 * creator - creator 등록 완료, 
			 * patron - patron 등록 완료)
			 */
			UserProfile admin = UserProfile.createUser("user@gmail.com", "1234", "고흐");
			em.persist(admin);

			// admin creator
			UploadFile creatorImage = UploadFile.createUploadFile("고흐.jpg",
					"https://sunminki.s3.ap-northeast-2.amazonaws.com/1d741251-946f-43cf-a640-c92442a697f7.jpg");
			Creator creator = Creator.createCreator("고흐", creatorImage, "otherUri", admin);
			em.persist(creator);
			
			// admin artwork - 1
			List<UploadFile> artWorkImages1 = new ArrayList<UploadFile>();
			artWorkImages1.add(UploadFile.createUploadFile("별이빛나는밤에.JPG",
					"https://sunminki.s3.ap-northeast-2.amazonaws.com/2fb61b17-7dcb-43ab-8a33-7bfb7ff83611.JPG"));
			artWorkImages1.add(UploadFile.createUploadFile("카페.JPG",
					"https://sunminki.s3.ap-northeast-2.amazonaws.com/d6d96ab0-d8f0-413e-b683-aaea23a89e2e.JPG"));
			artWorkImages1.add(UploadFile.createUploadFile("침대.JPG",
					"https://sunminki.s3.ap-northeast-2.amazonaws.com/b3b5addc-9b57-4639-a043-e4b455679bbd.JPG"));
			ArtWork artwork1 = ArtWork.createArtWork("고흐의 작품들", "이것은 별이 빛나고 있는 카페의 침대에 대한 내용입니다.", ArtWorkCategory.풍경화, creator, artWorkImages1);
			em.persist(artwork1);
			
			// admin artwork - 2
			List<UploadFile> artWorkImages2 = new ArrayList<UploadFile>();
			artWorkImages2.add(UploadFile.createUploadFile("해바라기.JPG",
					"https://sunminki.s3.ap-northeast-2.amazonaws.com/99e159d2-c5f9-427e-bfe1-efec77549c54.JPG"));
			ArtWork artwork2 = ArtWork.createArtWork("해바라기", "이것은 고흐의 해바라기에 대한 내용입니다.", ArtWorkCategory.정물화, creator, artWorkImages2);
			em.persist(artwork2);
			
			// admin artwork - 3
			List<UploadFile> artWorkImages3 = new ArrayList<UploadFile>();
			artWorkImages3.add(UploadFile.createUploadFile("밀밭.JPG",
					"https://sunminki.s3.ap-northeast-2.amazonaws.com/1d4bf854-584a-4b1b-b870-c8a61e4732ac.JPG"));
			ArtWork artwork3 = ArtWork.createArtWork("사이프러스가 서 있는 밀밭", "사이프러스가 서 있는 밀밭. 고흐, 1889년 6월 유화", ArtWorkCategory.풍경화, creator, artWorkImages3);
			em.persist(artwork3);
			
			// admin patron(후원등록 creator)
			List<UploadFile> patronImages = new ArrayList<UploadFile>();
			patronImages.add(UploadFile.createUploadFile("별이빛나는밤에.JPG",
					"https://sunminki.s3.ap-northeast-2.amazonaws.com/2fb61b17-7dcb-43ab-8a33-7bfb7ff83611.JPG"));
			patronImages.add(UploadFile.createUploadFile("카페.JPG",
					"https://sunminki.s3.ap-northeast-2.amazonaws.com/d6d96ab0-d8f0-413e-b683-aaea23a89e2e.JPG"));
			patronImages.add(UploadFile.createUploadFile("침대.JPG",
					"https://sunminki.s3.ap-northeast-2.amazonaws.com/b3b5addc-9b57-4639-a043-e4b455679bbd.JPG"));
				
			Patron patron = Patron.createPatron("나는 고흐다. 배고프다...", "저는 고흐입니다. 저에게 투자하시면 나중에 빛을 보실껍니다. 저는 이 돈으로 압생트를 사먹을 겁니다.", creator, patronImages);
			em.persist(patron);
			
			
			/**
			 * user - user1 조커
			 * creator - creator1 등록 완료, 
			 * patron - 미등록)
			 */
			UserProfile user1 = UserProfile.createUser("user1@gmail.com", "1234", "dlwngus");
			em.persist(user1);

			// user1 creator
			UploadFile creatorImage1 = UploadFile.createUploadFile("user1.JPG",
					"https://sunminki.s3.ap-northeast-2.amazonaws.com/a173df44-0776-470b-9322-d8d4dc22b25c.JPG");
			Creator creator1 = Creator.createCreator("조커", creatorImage1, "otherUri", user1);
			em.persist(creator1);

			
			
			/**
			 * user - user2 
			 * creator - 미등록, 
			 * patron - 미등록)
			 */
			UserProfile user2 = UserProfile.createUser("user2@gmail.com", "1234", "dlwngus");
			em.persist(user2);
			
			
			
			
			
			RewardCategory[] rewardCategory = RewardCategory.values();
			
			// user3 ~ 50 (creator 등록, patron 미등록)
			/**
			 * user - userProfile(user3 ~user100) 
			 * creator - creators(제작자3 ~ 제작자100), 
			 * patron - bobPatron 등록
			 * reward - reward - (달력, 컵, 노트 이미지 등록, 나머지는 default))
			 */
			for (int i = 3; i <= 100; i++) {
				String userString = "user" + String.valueOf(i);
				UserProfile userProfile = UserProfile.createUser(userString + "@gmail.com", "1234", userString);
				em.persist(userProfile);
				
				// 참쉽죠 아저씨 이미지 
				UploadFile creatorImageDefault = UploadFile.createUploadFile("밥로스.JPG",
						"https://sunminki.s3.ap-northeast-2.amazonaws.com/fe9b1626-bd9a-40ae-934f-6ec53b96b062.JPG");
				Creator creators = Creator.createCreator("제작자"+String.valueOf(i), creatorImageDefault, "www.naver.com", userProfile);
				em.persist(creators);
				
				
				// artwork 100개 (creators)
				List<UploadFile> artWorkImages = new ArrayList<UploadFile>();
				artWorkImages.add(UploadFile.createUploadFile("별이빛나는밤에.JPG",
						"https://sunminki.s3.ap-northeast-2.amazonaws.com/2fb61b17-7dcb-43ab-8a33-7bfb7ff83611.JPG"));
				artWorkImages.add(UploadFile.createUploadFile("카페.JPG",
						"https://sunminki.s3.ap-northeast-2.amazonaws.com/d6d96ab0-d8f0-413e-b683-aaea23a89e2e.JPG"));
				artWorkImages.add(UploadFile.createUploadFile("침대.JPG",
						"https://sunminki.s3.ap-northeast-2.amazonaws.com/b3b5addc-9b57-4639-a043-e4b455679bbd.JPG"));
				ArtWork artworks = ArtWork.createArtWork("고흐의 작품들TEST"+String.valueOf(i), "이것은 별이 빛나고 있는 카페의 침대에 대한 내용"+String.valueOf(i)+"입니다.", ArtWorkCategory.추상화, creators, artWorkImages);
				em.persist(artworks);
				
				
				// admin patron(후원등록 creator)
				List<UploadFile> bobImages = new ArrayList<UploadFile>();
				bobImages.add(UploadFile.createUploadFile("밥로스_산.JPG",
						"https://sunminki.s3.ap-northeast-2.amazonaws.com/48958747-6658-4803-a2d6-cc4bb41ed225.JPG"));
				bobImages.add(UploadFile.createUploadFile("밥로스_숲.JPG",
						"https://sunminki.s3.ap-northeast-2.amazonaws.com/3acb7a41-e7ee-4409-bcdd-9fafff667db0.JPG"));
				bobImages.add(UploadFile.createUploadFile("밥로스_노을산.JPG",
						"https://sunminki.s3.ap-northeast-2.amazonaws.com/e1730b52-28ad-4245-9359-375964ba1b41.JPG"));
				bobImages.add(UploadFile.createUploadFile("밥로스_설원.JPG",
						"https://sunminki.s3.ap-northeast-2.amazonaws.com/3db768bb-9b2e-432b-98bd-b28a9e6af5c4.JPG"));
				Patron bobPatron = Patron.createPatron("저는 그림이 쉬운 밥로스입니다.", "저는 밥로스입니다. 이렇게 그리면 됩니다. 참쉽죠?", creators, bobImages);
				em.persist(bobPatron);
				
				// admin reward(후원등록 creator)
				List<UploadFile> rewardImages = new ArrayList<UploadFile>();
				String itemName = rewardCategory[i % rewardCategory.length].toString();
				
				if (itemName.equals(RewardCategory.calendar.toString())) {
					rewardImages.add(UploadFile.createUploadFile("calendar.JPG", "https://sunminki.s3.ap-northeast-2.amazonaws.com/17c51c8c-ccbf-4f80-b29b-204659fefd6c.JPG"));
					rewardImages.add(UploadFile.createUploadFile("calendar2.JPG", "https://sunminki.s3.ap-northeast-2.amazonaws.com/d5cb43ed-86c8-477c-9294-aea7b05996b8.JPG"));
				}
				else if (itemName.equals(RewardCategory.cup.toString())) {
					rewardImages.add(UploadFile.createUploadFile("cup.JPG", "https://sunminki.s3.ap-northeast-2.amazonaws.com/3dd96fb8-5112-4b28-9a1a-4ce85cb91f74.JPG"));
					rewardImages.add(UploadFile.createUploadFile("cup2.JPG", "https://sunminki.s3.ap-northeast-2.amazonaws.com/950b49d1-da98-4be9-bd5e-408d98484ca3.JPG"));
				}
				else if(itemName.equals(RewardCategory.note.toString())) {
					rewardImages.add(UploadFile.createUploadFile("note.JPG", "https://sunminki.s3.ap-northeast-2.amazonaws.com/6b4247b3-a10e-4ec7-995b-e0bb11d4afd8.JPG"));
					rewardImages.add(UploadFile.createUploadFile("note2.JPG", "https://sunminki.s3.ap-northeast-2.amazonaws.com/79c5f226-2d24-4ba1-a1d3-8f6be0702c87.JPG"));
				}else {
					rewardImages.add(UploadFile.createUploadFile("rewardDefault.JPG","https://sunminki.s3.ap-northeast-2.amazonaws.com/c04a08bd-8ae3-44d8-9405-268e449eacdc.JPG"));
				}
				
				Reward reward = Reward.createReward("리워드"+ String.valueOf(i), "내용"+String.valueOf(i), i*10000, itemName, bobPatron , rewardImages);
				em.persist(reward);
			}

			// 콜라보레이션 initDB
			
			/**
			 * creator : admin
			 * collaboration : AK플라자와 함께 하는 일상 일러스트 공모전 
			 * image : collabo1.JPG
			 */
			Collaboration collaboration1 = Collaboration.createCollaboration(
					"AK플라자와 함께 하는 일상 일러스트 공모전", 
					LocalDateTime.now().plusDays(7), 
					"참여 방법\r\n" + 
					"분당, 수원, 평택, 원주 AK플라자에서 즐거운 하루를 보내는 나의 일상의 모습을 그려주세요!\r\n" + 
					"※ 지역구분은 AK플라자 입점 지역인 분당/수원/평택/원주에 한합니다.", 
					creator, 
					"https://sunminki.s3.ap-northeast-2.amazonaws.com/f97bc0b0-262d-49d4-a9eb-f455d4666499.JPG");
			em.persist(collaboration1);
			
			/**
			 * creator : creator1
			 * collaboration : AK플라자와 함께 하는 일상 일러스트 공모전 
			 * collaborationArtWork : AK플라자 수원점, 도심속의 휴가 
			 * image : collaboartwork1-1.JPG
			 */
			CollaborationArtWork collabo1_1 = CollaborationArtWork.createCollaborationArtWork(
					"AK플라자 수원점, 도심속의 휴가", 
					"마치 도심 속 휴양지에 온 듯한\r\n" + 
					"AK플라자 수원점에서\r\n" + 
					"가족 또는 친구, 연인과 함께 보내는 즐거운 하루.", 
					creator1,
					"https://sunminki.s3.ap-northeast-2.amazonaws.com/86ff7b55-2e81-4406-b041-e5097d4a95eb.JPG", 
					collaboration1);
			em.persist(collabo1_1);
			
			/**
			 * creator : creator1
			 * collaboration : AK플라자와 함께 하는 일상 일러스트 공모전 
			 * collaborationArtWork : 분당 AK 식품관 
			 * image : collaboartwork1-2.JPG
			 */
			CollaborationArtWork collabo1_2 = CollaborationArtWork.createCollaborationArtWork(
					"분당 AK 식품관", 
					"식품관 갔는데 식중독걸렸어요. 배상해주세요.", 
					creator1,
					"https://sunminki.s3.ap-northeast-2.amazonaws.com/350bc0cf-ecea-40c0-8468-eb4171e8482c.JPG", 
					collaboration1);
			em.persist(collabo1_2);
			
			
			/**
			 * creator : creator1
			 * collaboration : AK플라자와 함께 하는 일상 일러스트 공모전 
			 * collaborationArtWork : daily life in ak 분당
			 * image : collaboartwork1-3.JPG
			 */
			CollaborationArtWork collabo1_3 = CollaborationArtWork.createCollaborationArtWork(
					"daily life in ak 분당", 
					"건물이 많이 크던데요?", 
					creator1,
					"https://sunminki.s3.ap-northeast-2.amazonaws.com/fe6e509d-d195-467b-a8f0-b1b029a52104.JPG", 
					collaboration1);
			em.persist(collabo1_3);
			
			
			/**
			 * creator : creator1
			 * collaboration : 내가 그리는 로스터리R 패키지 일러스트 공모전
			 * image : collabo2.JPG
			 */
			Collaboration collaboration2 = Collaboration.createCollaboration(
					"내가 그리는 로스터리R 패키지 일러스트 공모전", 
					LocalDateTime.now().plusDays(3), 
					"참여 방법\r\n" + 
					"로스터리R 로고를 중심으로 로스터리 컵커피에 어울리는 패키지를 자유롭게 디자인해주세요.\r\n" + 
					"내 작품이 한정판 제품 패키지로 출시되는 기회를 드립니다.", 
					creator1, 
					"https://sunminki.s3.ap-northeast-2.amazonaws.com/b7bb7245-f151-4e77-9889-199b61e095d9.JPG");
			em.persist(collaboration2);
			
			/**
			 * creator : creator(admin)
			 * collaboration : 내가 그리는 로스터리R 패키지 일러스트 공모전
			 * collaborationArtWork : 로스터리R 리치왕의 분노 패키지
			 * image : collaboartwork2-1.JPG
			 */
			CollaborationArtWork collabo2_1 = CollaborationArtWork.createCollaborationArtWork(
					"로스터리R 리치왕의 분노 패키지", 
					"아들아...너가 태어나던 날.. 로스터리를 마시던 모든 사람들이 속삭였단다.. 아이스...", 
					creator,
					"https://sunminki.s3.ap-northeast-2.amazonaws.com/104516de-26e0-4ac0-889e-abcdc7c2465c.JPG", 
					collaboration2);
			em.persist(collabo2_1);
			
			/**
			 * creator : creator(admin)
			 * collaboration : 내가 그리는 로스터리R 패키지 일러스트 공모전
			 * collaborationArtWork : 로스터리R-샤워할때 생각나는 맛
			 * image : collaboartwork2-2.JPG
			 */
			CollaborationArtWork collabo2_2 = CollaborationArtWork.createCollaborationArtWork(
					"로스터리R-샤워할때 생각나는 맛", 
					"샤워하고 나서 한잔 먹으면 맛있어요.", 
					creator,
					"https://sunminki.s3.ap-northeast-2.amazonaws.com/3795aca1-6cf2-4317-8e27-63e3d004ea87.JPG", 
					collaboration2);
			em.persist(collabo2_2);
			
			/**
			 * creator : creator(admin)
			 * collaboration : 내가 그리는 로스터리R 패키지 일러스트 공모전
			 * collaborationArtWork : 로스터리R-성냥팔이 소녀 패키지
			 * image : collaboartwork2-3.JPG
			 */
			CollaborationArtWork collabo2_3 = CollaborationArtWork.createCollaborationArtWork(
					"로스터리R-성냥팔이 소녀 패키지", 
					"성냥팔이 소녀가 성냥을 팔고난 후... 주머니에 있던 3000원...그걸로 뭘샀는지 아십니까?", 
					creator,
					"https://sunminki.s3.ap-northeast-2.amazonaws.com/5d8e76ed-351b-4443-890c-f09064b55608.JPG", 
					collaboration2);
			em.persist(collabo2_3);
			
			
			/**
			 * creator : creator(admin)
			 * collaboration : 내가 그리는 로스터리R 패키지 일러스트 공모전
			 * collaborationArtWork : 로스터리R-카페보다 맛있는 맛
			 * image : collaboartwork2-4.JPG
			 */
			CollaborationArtWork collabo2_4 = CollaborationArtWork.createCollaborationArtWork(
					"로스터리R-카페보다 맛있는 맛", 
					"카페를 가지말고 로스터리R을 사먹으세요. 가성비 좋아요.", 
					creator,
					"https://sunminki.s3.ap-northeast-2.amazonaws.com/9a82bfde-82d0-4e57-ba8b-dc0faa0b1353.JPG", 
					collaboration2);
			em.persist(collabo2_4);
			
			/**
			 * creator : creator1
			 * collaboration : 제7회 상상만발 책그림전
			 * image : collabo3.JPG
			 */
			Collaboration collaboration3 = Collaboration.createCollaboration(
					"제7회 상상만발 책그림전", 
					LocalDateTime.now().minusDays(1), 
					"참여 방법\r\n" + 
					"* 각각의 이미지 사이즈는 10MB 안에서 자유롭게 조정할 수 있습니다. (단, 표지는 640px 크기로 노출됩니다)\r\n" + 
					"* 콜라보레이션의 취지(주제와 무관 또는 광고, 타인 작품 도용 등)에 맞지 않는 응모작은 보기가 제한될 수 있습니다.", 
					creator1, 
					"https://sunminki.s3.ap-northeast-2.amazonaws.com/f4f4979b-aad5-435c-bc72-8a5858ffcac6.JPG");
			em.persist(collaboration3);
			
			/**
			 * creator : creator
			 * collaboration : 제7회 상상만발 책그림전
			 * collaborationArtWork : 너를 기다리는 시간
			 * image : collaboartwork3-1.JPG
			 */
			CollaborationArtWork collabo3_1 = CollaborationArtWork.createCollaborationArtWork(
					"너를 기다리는 시간", 
					"아 주인님 좀 빨리와요 제발", 
					creator,
					"https://sunminki.s3.ap-northeast-2.amazonaws.com/8f09f2f6-bce5-4356-95ca-24041cef96a9.JPG", 
					collaboration3);
			em.persist(collabo3_1);
			
			/**
			 * creator : creator
			 * collaboration : 제7회 상상만발 책그림전
			 * collaborationArtWork : 나는 괴물이에요.
			 * image : collaboartwork3-2.JPG
			 */
			CollaborationArtWork collabo3_2 = CollaborationArtWork.createCollaborationArtWork(
					"나는 괴물이에요.", 
					"나는 괴물이지만 너는 나물이에요.", 
					creator,
					"https://sunminki.s3.ap-northeast-2.amazonaws.com/d2a1bcc3-3e1d-4305-bce1-ebe25faeded2.JPG", 
					collaboration3);
			em.persist(collabo3_2);
			
			/**
			 * creator : creator
			 * collaboration : 제7회 상상만발 책그림전
			 * collaborationArtWork : 4번 달걀의 비밀
			 * image : collaboartwork3-3.JPG
			 */
			CollaborationArtWork collabo3_3 = CollaborationArtWork.createCollaborationArtWork(
					"4번 달걀의 비밀", 
					"4번은 개인주의", 
					creator,
					"https://sunminki.s3.ap-northeast-2.amazonaws.com/a1643e2c-49fa-4e8d-b67c-c639f460a54e.JPG", 
					collaboration3);
			em.persist(collabo3_3);
			
			
			// jpa 영속성 컨텍스트 초기화
			em.flush();
			em.clear();
		}

	}
}
