package me.yusrisahrul.moviecatalogue.utils

import me.yusrisahrul.moviecatalogue.data.model.Movie
import me.yusrisahrul.moviecatalogue.data.model.TvShow

class DataDummy {

    fun generateDummyMovies() : ArrayList<Movie> {
        val movies = ArrayList<Movie>()

        movies.add(
            Movie(
                "1",
                "Ad Astra",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/" +
                        "lNnomQxXpRP9mgUwMuSZhA8LXfA.jpg",
                "The near future, a time when both hope and hardships drive humanity to " +
                        "look to the stars and beyond. While a mysterious phenomenon menaces to " +
                        "destroy life on planet Earth, astronaut Roy McBride undertakes a mission" +
                        " across the immensity of space and its many perils to uncover the truth " +
                        "about a lost expedition that decades before boldly faced emptiness and " +
                        "silence in search of the unknown.",
                "September 17, 2019",
                "6.0"
            )
        )

        movies.add(
            Movie(
                "2",
                "Star Wars: The Rise of Skywalker",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/" +
                        "db32LaOibwEliAmSL2jjDF6oDdj.jpg",
                "The surviving Resistance faces the First Order once again as the " +
                        "journey of Rey, Finn and Poe Dameron continues. With the power and " +
                        "knowledge of generations behind them, the final battle begins.",
                "December 18, 2019",
                "6.6"
            )
        )

        movies.add(
            Movie(
                "3",
                "Joker",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/" +
                        "udDclJoHjfjb8Ekgsd4FDteOkCU.jpg",
                "During the 1980s, a failed stand-up comedian is driven insane and " +
                        "turns to a life of crime and chaos in Gotham City while becoming an " +
                        "infamous psychopathic crime figure.",
                "October 2, 2019",
                "8.3"
            )
        )

        movies.add(
            Movie(
                "4",
                "Jumanji: The Next Level",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/" +
                        "jyw8VKYEiM1UDzPB7NsisUgBeJ8.jpg",
                "As the gang return to Jumanji to rescue one of their own, they " +
                        "discover that nothing is as they expect. The players will have to brave " +
                        "parts unknown and unexplored in order to escape the world’s most " +
                        "dangerous game.",
                "December 4, 2019",
                "6.7"
            )
        )

        movies.add(
            Movie(
                "5",
                "Maleficent: Mistress of Evil",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/" +
                        "vloNTScJ3w7jwNwtNGoG8DbTThv.jpg",
                "Maleficent and her goddaughter Aurora begin to question the complex " +
                        "family ties that bind them as they are pulled in different directions " +
                        "by impending nuptials, unexpected allies, and dark new forces at play.",
                "October 16, 2019",
                "7.2"
            )
        )

        movies.add(
            Movie(
                "6",
                "Ip Man 4: The Finale",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/" +
                        "yJdeWaVXa2se9agI6B4mQunVYkB.jpg",
                "Following the death of his wife, Ip Man travels to San Francisco to " +
                        "ease tensions between the local kung fu masters and his star student, " +
                        "Bruce Lee, while searching for a better future for his son.",
                "December 20, 2019",
                "6.0"
            )
        )

        movies.add(
            Movie(
                "7",
                "Frozen II",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/" +
                        "pjeMs3yqRmFL3giJy4PMXWZTTPa.jpg",
                "Elsa, Anna, Kristoff and Olaf head far into the forest to learn the " +
                        "truth about an ancient mystery of their kingdom.",
                "November 20, 2019",
                "7.0"
            )
        )

        movies.add(
            Movie(
                "8",
                "Parasite",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/" +
                        "7IiTTgloJzvGI1TAYymCfbfl3vT.jpg",
                "All unemployed, Ki-taek's family takes peculiar interest in the " +
                        "wealthy and glamorous Parks for their livelihood until they get " +
                        "entangled in an unexpected incident.",
                "May 30, 2019",
                "8.6"
            )
        )

        movies.add(
            Movie(
                "9",
                "1917",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/" +
                        "Aqr1jDwGb1IfAB6Lh1fNx7AbEZE.jpg",
                "At the height of the First World War, two young British soldiers, " +
                        "Schofield and Blake are given a seemingly impossible mission. In a race " +
                        "against time, they must cross enemy territory and deliver a message " +
                        "that will stop a deadly attack on hundreds of soldiers—Blake's own " +
                        "brother among them.",
                "December 10, 2019",
                "7.9"
            )
        )

        movies.add(
            Movie(
                "10",
                "Gundala",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/" +
                        "eU0orGizEpOli4wtN8HtfOOJDlA.jpg",
                "Sancaka has lived on the streets since his parents left him. " +
                        "Living a hard life, Sancaka survives by thinking about his own safety. " +
                        "When the condition of the city gets worse and injustice rages throughout" +
                        " the country, Sancaka must decide whether he continues to live to look " +
                        "after himself or rise to become their oppressed hero.",
                "August 29, 2019",
                "5.4"
            )
        )

        return movies
    }

    fun generateDummyTvShows() : ArrayList<TvShow> {
        val tvShows = ArrayList<TvShow>()

        tvShows.add(
            TvShow(
                "1",
                "Vikings",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/" +
                        "ff1zhqvwfS5HvRNcA5UFrH0PA2q.jpg",
                "The adventures of Ragnar Lothbrok, the greatest hero of his age. " +
                        "The series tells the sagas of Ragnar's band of Viking brothers and his " +
                        "family, as he rises to become King of the Viking tribes. As well as " +
                        "being a fearless warrior, Ragnar embodies the Norse traditions of" +
                        " devotion to the gods. Legend has it that he was a direct descendant" +
                        " of Odin, the god of war and warriors.",
                "March 3, 2013",
                "7.5"
            )
        )

        tvShows.add(
            TvShow(
                "2",
                "The Mandalorian",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/" +
                        "BbNvKCuEF4SRzFXR16aK6ISFtR.jpg",
                "After the fall of the Galactic Empire, lawlessness has spread " +
                        "throughout the galaxy. A lone gunfighter makes his way through the " +
                        "outer reaches, earning his keep as a bounty hunter.",
                "November 12, 2019",
                "8.0"
            )
        )

        tvShows.add(
            TvShow(
                "3",
                "Arrow",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/" +
                        "gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed" +
                        " dead when his yacht is lost at sea. He returns five years later a" +
                        " changed man, determined to clean up the city as a hooded vigilante " +
                        "armed with a bow.",
                "October 10, 2012",
                "5.9"
            )
        )

        tvShows.add(
            TvShow(
                "4",
                "True Cooking Master Boy",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/" +
                        "mg2fUxfH3ktaWqbSq4oL3g3yyCm.jpg",
                "After the death of Mao's mother - Pai - who was called the Goddess" +
                        " of Cuisine, Mao wants to be the Master Chef of his mother's restaurant." +
                        " However, before Mao takes his mother's place as Master Chef, he travels" +
                        " to China in order to learn more of the many ways of cooking, in the" +
                        " hopes of becoming a legendary chef just like his mother.",
                "October 11, 2019",
                "8.0"
            )
        )

        tvShows.add(
            TvShow(
                "5",
                "The Flash",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/" +
                        "wHa6KOJAoNTFLFtp7wguUJKSnju.jpg",
                "After a particle accelerator causes a freak storm, CSI Investigator" +
                        " Barry Allen is struck by lightning and falls into a coma. Months later" +
                        " he awakens with the power of super speed, granting him the ability to" +
                        " move through Central City like an unseen guardian angel. Though " +
                        "initially excited by his newfound powers, Barry is shocked to discover" +
                        " he is not the only \"meta-human\" who was created in the wake of the" +
                        " accelerator explosion -- and not everyone is using their new powers " +
                        "for good. Barry partners with S.T.A.R. Labs and dedicates his life to" +
                        " protect the innocent. For now, only a few close friends and associates" +
                        " know that Barry is literally the fastest man alive, but it won't be" +
                        " long before the world learns what Barry Allen has become...The Flash.",
                "October 7, 2014",
                "6.8"
            )
        )

        tvShows.add(
            TvShow(
                "6",
                "Doctor Who",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/" +
                        "cDDb7WA2i7cENhkEEjXEDrXGyNL.jpg",
                "The Doctor is a Time Lord: a 900 year old alien with 2 hearts, part" +
                        " of a gifted civilization who mastered time travel. The Doctor saves" +
                        " planets for a living—more of a hobby actually, and the Doctor's very," +
                        " very good at it.",
                "March 26, 2005",
                "7.0"
            )
        )

        tvShows.add(
            TvShow(
                "7",
                "The Simpsons",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/" +
                        "yTZQkSsxUFJZJe67IenRM0AEklc.jpg",
                "Set in Springfield, the average American town, the show focuses on " +
                        "the antics and everyday adventures of the Simpson family; Homer, Marge," +
                        " Bart, Lisa and Maggie, as well as a virtual cast of thousands. " +
                        "Since the beginning, the series has been a pop culture icon, attracting" +
                        " hundreds of celebrities to guest star. The show has also made name for " +
                        "itself in its fearless satirical take on politics, media and American" +
                        " life in general.",
                "December 17, 1989",
                "7.2"
            )
        )

        tvShows.add(
            TvShow(
                "8",
                "Rick and Morty",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/" +
                        "qJdfO3ahgAMf2rcmhoqngjBBZW1.jpg",
                "Rick is a mentally-unbalanced but scientifically-gifted old man who " +
                        "has recently reconnected with his family. He spends most of his time " +
                        "involving his young grandson Morty in dangerous, outlandish adventures" +
                        " throughout space and alternate universes. Compounded with Morty's " +
                        "already unstable family life, these events cause Morty much distress at" +
                        " home and school.",
                "December 2, 2013",
                "8.6"
            )
        )

        tvShows.add(
            TvShow(
                "9",
                "Law & Order: Special Victims Unit",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/" +
                        "6t6r1VGQTTQecN4V0sZeqsmdU9g.jpg",
                "In the criminal justice system, sexually-based offenses are" +
                        " considered especially heinous. In New York City, the dedicated " +
                        "detectives who investigate these vicious felonies are members of an" +
                        " elite squad known as the Special Victims Unit. These are their stories.",
                "September 20, 1999",
                "6.5"
            )
        )

        tvShows.add(
            TvShow(
                "10",
                "Haikyuu!!",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/" +
                        "aXhi0b2MZWHekY402PyNjrj3LnR.jpg",
                "Shōyō Hinata began playing volleyball after seeing the " +
                        "\"small giants\" who played the sport when he was in elementary school. " +
                        "He suffers a crushing defeat in his first and last tournament " +
                        "in middle school at the hands of his rival Tobio Kageyama. So, Hinata " +
                        "joins Kurasuno High School's volleyball team, vowing revenge against " +
                        "Kageyama. However, Kageyama is also on Kurasuno's team. The former " +
                        "rivals form a legendary combo with Hinata's mobility and Kageyama's " +
                        "precision ball-handling. Together, they take on the local tournaments" +
                        " and vow to meet Kurasuno's fated rival school in the nationals.",
                "April 6, 2014",
                "8.4"
            )
        )

        return tvShows
    }

    fun generateRemoteDummyMovies() : List<Movie> {
        val movies = ArrayList<Movie>()

        movies.add(
            Movie(
                "19404",
                "Dilwale Dulhania Le Jayenge",
                "/2CAL2433ZeIihfX1Hb2139CX0pW.jpg",
                "Raj is a rich, carefree, happy-go-lucky second generation NRI. Simran" +
                        " is the daughter of Chaudhary Baldev Singh, who in spite of being an NRI" +
                        " is very strict about adherence to Indian values. Simran has left for" +
                        " India to be married to her childhood fiancé. Raj leaves for India with" +
                        " a mission at his hands, to claim his lady love under the noses of her" +
                        " whole family. Thus begins a saga.",
                "1995-10-20",
                "8.8"
            )
        )

        movies.add(
            Movie(
                "278",
                "The Shawshank Redemption",
                "/9O7gLzmreU0nGkIB6K3BsJbzvNv.jpg",
                "Framed in the 1940s for the double murder of his wife and her lover," +
                        " upstanding banker Andy Dufresne begins a new life at the Shawshank" +
                        " prison, where he puts his accounting skills to work for an amoral" +
                        " warden. During his long stretch in prison, Dufresne comes to be admired" +
                        " by the other inmates -- including an older prisoner named Red -- for" +
                        " his integrity and unquenchable sense of hope.",
                "1994-09-23",
                "8.7"
            )
        )

        movies.add(
            Movie(
                "238",
                "The Godfather",
                "/rPdtLWNsZmAtoZl9PK7S2wE3qiS.jpg",
                "Spanning the years 1945 to 1955, a chronicle of the fictional" +
                        " Italian-American Corleone crime family. When organized crime family " +
                        "patriarch, Vito Corleone barely survives an attempt on his life, his " +
                        "youngest son, Michael steps in to take care of the would-be killers, " +
                        "launching a campaign of bloody revenge.",
                "1972-03-14",
                "8.6"
            )
        )

        movies.add(
            Movie(
                "496243",
                "Parasite",
                "/7IiTTgloJzvGI1TAYymCfbfl3vT.jpg",
                "All unemployed, Ki-taek's family takes peculiar interest in the" +
                        " wealthy and glamorous Parks for their livelihood until they get " +
                        "entangled in an unexpected incident.",
                "2019-05-30",
                "8.6"
            )
        )

        movies.add(
            Movie(
                "424",
                "Schindler's List",
                "/yPisjyLweCl1tbgwgtzBCNCBle.jpg",
                "The true story of how businessman Oskar Schindler saved over a" +
                        " thousand Jewish lives from the Nazis while they worked as slaves in" +
                        " his factory during World War II.",
                "1993-11-30",
                "8.6"
            )
        )

        movies.add(
            Movie(
                "240",
                "The Godfather: Part II",
                "/bVq65huQ8vHDd1a4Z37QtuyEvpA.jpg",
                "In the continuing saga of the Corleone crime family, a young Vito" +
                        " Corleone grows up in Sicily and in 1910s New York. In the 1950s," +
                        " Michael Corleone attempts to expand the family business into Las Vegas," +
                        " Hollywood and Cuba.",
                "1974-12-20",
                "8.5"
            )
        )

        movies.add(
            Movie(
                "372058",
                "Your Name.",
                "/xq1Ugd62d23K2knRUx6xxuALTZB.jpg",
                "High schoolers Mitsuha and Taki are complete strangers living" +
                        " separate lives. But one night, they suddenly switch places. Mitsuha" +
                        " wakes up in Taki’s body, and he in hers. This bizarre occurrence" +
                        " continues to happen randomly, and the two must adjust their lives" +
                        " around each other.",
                "2016-08-26",
                "8.5"
            )
        )

        movies.add(
            Movie(
                "129",
                "Spirited Away",
                "/oRvMaJOmapypFUcQqpgHMZA6qL9.jpg",
                "A young girl, Chihiro, becomes trapped in a strange new world of" +
                        " spirits. When her parents undergo a mysterious transformation, she " +
                        "must call upon the courage she never knew she had to free her family.",
                "2001-07-20",
                "8.5"
            )
        )

        movies.add(
            Movie(
                "497",
                "The Green Mile",
                "/sOHqdY1RnSn6kcfAHKu28jvTebE.jpg",
                "A supernatural tale set on death row in a Southern prison, where" +
                        " gentle giant John Coffey possesses the mysterious power to heal " +
                        "people's ailments. When the cell block's head guard, Paul Edgecomb, " +
                        "recognizes Coffey's miraculous gift, he tries desperately to help stave" +
                        " off the condemned man's execution.",
                "1999-12-10",
                "8.5"
            )
        )

        movies.add(
            Movie(
                "680",
                "Pulp Fiction",
                "/d5iIlFn5s0ImszYzBPb8JPIfbXD.jpg",
                "A burger-loving hit man, his philosophical partner, a drug-addled" +
                        " gangster's moll and a washed-up boxer converge in this sprawling, " +
                        "comedic crime caper. Their adventures unfurl in three stories that " +
                        "ingeniously trip back and forth in time.",
                "1994-09-10",
                "8.5"
            )
        )

        movies.add(
            Movie(
                "637",
                "Life Is Beautiful",
                "/f7DImXDebOs148U4uPjI61iDvaK.jpg",
                "A touching story of an Italian book seller of Jewish ancestry who " +
                        "lives in his own little fairy tale. His creative and happy life would " +
                        "come to an abrupt halt when his entire family is deported to a " +
                        "concentration camp during World War II. While locked up he tries to " +
                        "convince his son that the whole thing is just a game.",
                "1997-12-20",
                "8.5"
            )
        )

        movies.add(
            Movie(
                "13",
                "Forrest Gump",
                "/yE5d3BUhE8hCnkMUJOo1QDoOGNz.jpg",
                "A man with a low IQ has accomplished great things in his life and been" +
                        " present during significant historic events—in each case, far exceeding" +
                        " what anyone imagined he could do. But despite all he has achieved," +
                        " his one true love eludes him.",
                "1994-07-06",
                "8.4"
            )
        )

        movies.add(
            Movie(
                "155",
                "The Dark Knight",
                "/pKKvCaL1TPTVtbI6EeliyND3api.jpg",
                "Batman raises the stakes in his war on crime. With the help of Lt." +
                        " Jim Gordon and District Attorney Harvey Dent, Batman sets out to " +
                        "dismantle the remaining criminal organizations that plague the streets. " +
                        "The partnership proves to be effective, but they soon find themselves" +
                        " prey to a reign of chaos unleashed by a rising criminal mastermind" +
                        " known to the terrified citizens of Gotham as the Joker.",
                "2008-07-16",
                "8.4"
            )
        )

        movies.add(
            Movie(
                "311",
                "Once Upon a Time in America",
                "/x733R4ISI0RbKeHhVkXdTMFmTFr.jpg",
                "A former Prohibition-era Jewish gangster returns to the Lower East" +
                        " Side of Manhattan over thirty years later, where he once again must" +
                        " confront the ghosts and regrets of his old life.",
                "1984-05-23",
                "8.4"
            )
        )

        movies.add(
            Movie(
                "346",
                "Seven Samurai",
                "/v6xrz4fr92KY1oNC3HsEvrsvR1n.jpg",
                "A samurai answers a village's request for protection after he falls" +
                        " on hard times. The town needs protection from bandits, so the samurai" +
                        " gathers six others to help him teach the people how to defend " +
                        "themselves, and the villagers provide the soldiers with food. A giant" +
                        " battle occurs when 40 bandits attack the village.",
                "1954-04-26",
                "8.4"
            )
        )

        movies.add(
            Movie(
                "40096",
                "A Dog's Will",
                "/m8eFedsS7vQCZCS8WGp5n1bVD0q.jpg",
                "The lively João Grilo and the sly Chicó are poor guys living in the" +
                        " hinterland who cheat a bunch of people in a small Northeast Brazil" +
                        " town. But when they die, they have to be judged by Christ, the Devil " +
                        "and the Virgin Mary, before they are admitted to paradise.",
                "2000-09-15",
                "8.4"
            )
        )

        movies.add(
            Movie(
                "122",
                "The Lord of the Rings: The Return of the King",
                "/rCzpDGLbOoPwLjy3OAm5NUPOTrC.jpg",
                "Aragorn is revealed as the heir to the ancient kings as he, " +
                        "Gandalf and the other members of the broken fellowship struggle to " +
                        "save Gondor from Sauron's forces. Meanwhile, Frodo and Sam take the " +
                        "ring closer to the heart of Mordor, the dark lord's realm.",
                "2003-12-01",
                "8.4"
            )
        )

        movies.add(
            Movie(
                "389",
                "12 Angry Men",
                "/3W0v956XxSG5xgm7LB6qu8ExYJ2.jpg",
                "The defense and the prosecution have rested and the jury is filing " +
                        "into the jury room to decide if a young Spanish-American is guilty or " +
                        "innocent of murdering his father. What begins as an open and shut case " +
                        "soon becomes a mini-drama of each of the jurors' prejudices and " +
                        "preconceptions about the trial, the accused, and each other.",
                "1957-04-10",
                "8.4"
            )
        )

        movies.add(
            Movie(
                "769",
                "GoodFellas",
                "/pwpGfTImTGifEGgLb3s6LRPd4I6.jpg",
                "The true story of Henry Hill, a half-Irish, half-Sicilian Brooklyn" +
                        " kid who is adopted by neighbourhood gangsters at an early age and" +
                        " climbs the ranks of a Mafia family under the guidance of Jimmy Conway.",
                "1990-09-12",
                "8.4"
            )
        )

        movies.add(
            Movie(
                "429",
                "The Good, the Bad and the Ugly",
                "/wfPHdfofBD5PN96dV96a51B3Ja2.jpg",
                "While the Civil War rages between the Union and the Confederacy, " +
                        "three men – a quiet loner, a ruthless hit man and a Mexican bandit –" +
                        " comb the American Southwest in search of a strongbox containing " +
                        "$200,000 in stolen gold.",
                "1966-12-23",
                "8.4"
            )
        )

        return movies
    }

    fun generateRemoteDummyTvShows() : List<TvShow> {
        val tvShow = ArrayList<TvShow>()

        tvShow.add(
            TvShow(
                "100",
                "I Am Not an Animal",
                "/nMhv6jG5dtLdW7rgguYWvpbk0YN.jpg",
                "I Am Not An Animal is an animated comedy series about the only six" +
                        " talking animals in the world, whose cosseted existence in a vivisection" +
                        " unit is turned upside down when they are liberated by animal rights" +
                        " activists.",
                "2004-05-10",
                "9.4"
            )
        )

        tvShow.add(
            TvShow(
                "87108",
                "Chernobyl",
                "/hlLXt2tOPT6RRnjiUmoxyG1LTFi.jpg",
                "The true story of one of the worst man-made catastrophes in history:" +
                        " the catastrophic nuclear accident at Chernobyl. A tale of the brave men" +
                        " and women who sacrificed to save Europe from unimaginable disaster.",
                "2019-05-06",
                "8.7"
            )
        )

        tvShow.add(
            TvShow(
                "60625",
                "Rick and Morty",
                "/qJdfO3ahgAMf2rcmhoqngjBBZW1.jpg",
                "Rick is a mentally-unbalanced but scientifically-gifted old man who" +
                        " has recently reconnected with his family. He spends most of his time" +
                        " involving his young grandson Morty in dangerous, outlandish adventures" +
                        " throughout space and alternate universes. Compounded with Morty's " +
                        "already unstable family life, these events cause Morty much distress" +
                        " at home and school.",
                "2013-12-02",
                "8.6"
            )
        )

        tvShow.add(
            TvShow(
                "1396",
                "Breaking Bad",
                "/1yeVJox3rjo2jBKrrihIMj7uoS9.jpg",
                "When Walter White, a New Mexico chemistry teacher, is diagnosed " +
                        "with Stage III cancer and given a prognosis of only two years left to" +
                        " live. He becomes filled with a sense of fearlessness and an unrelenting" +
                        " desire to secure his family's financial future at any cost as he enters" +
                        " the dangerous world of drugs and crime.",
                "2008-01-20",
                "8.5"
            )
        )

        tvShow.add(
            TvShow(
                "13916",
                "Death Note",
                "/g8hHbsRmHYoWYizhWCk87vpkrmy.jpg",
                "Light Yagami is an ace student with great prospects—and he’s bored" +
                        " out of his mind. But all that changes when he finds the Death Note," +
                        " a notebook dropped by a rogue Shinigami death god. Any human whose name" +
                        " is written in the notebook dies, and Light has vowed to use the power" +
                        " of the Death Note to rid the world of evil. But will Light succeed in" +
                        " his noble goal, or will the Death Note turn him into the very thing" +
                        " he fights against?",
                "2006-10-04",
                "8.4"
            )
        )

        tvShow.add(
            TvShow(
                "19885",
                "Sherlock",
                "/f9zGxLHGyQB10cMDZNY5ZcGKhZi.jpg",
                "A modern update finds the famous sleuth and his doctor partner solving" +
                        " crime in 21st century London.",
                "2010-07-25",
                "8.4"
            )
        )

        tvShow.add(
            TvShow(
                "60574",
                "Peaky Blinders",
                "/jeWoeUQyHdxGFNZCrzbOUP78FiZ.jpg",
                "A gangster family epic set in 1919 Birmingham, England and centered" +
                        " on a gang who sew razor blades in the peaks of their caps, and their" +
                        " fierce boss Tommy Shelby, who means to move up in the world.",
                "2013-09-12",
                "8.3"
            )
        )

        tvShow.add(
            TvShow(
                "66732",
                "Stranger Things",
                "/x2LSRK2Cm7MZhjluni1msVJ3wDF.jpg",
                "When a young boy vanishes, a small town uncovers a mystery involving" +
                        " secret experiments, terrifying supernatural forces, and one strange" +
                        " little girl.",
                "2016-07-15",
                "8.3"
            )
        )

        tvShow.add(
            TvShow(
                "33217",
                "Young Justice",
                "/oL31ADgSgVdgoJPRAdWISQBIO0w.jpg",
                "Teenage superheroes strive to prove themselves as members of the " +
                        "Justice League.",
                "2010-11-26",
                "8.3"
            )
        )

        tvShow.add(
            TvShow(
                "6357",
                "The Twilight Zone",
                "/7uY4pCOxbEdv4M8jTE4uMPVoSIW.jpg",
                "A series of unrelated stories containing drama, psychological " +
                        "thriller, fantasy, science fiction, suspense, and/or horror, often " +
                        "concluding with a macabre or unexpected twist.",
                "1959-10-02",
                "8.3"
            )
        )

        tvShow.add(
            TvShow(
                "40075",
                "Gravity Falls",
                "/oGsgxjeZ9rd20eCJsGSMGgWvl4P.jpg",
                "Twin brother and sister Dipper and Mabel Pines are in for an " +
                        "unexpected adventure when they spend the summer helping their great" +
                        " uncle Stan run a tourist trap in the mysterious town of Gravity Falls, " +
                        "Oregon.",
                "2012-06-15",
                "8.3"
            )
        )

        tvShow.add(
            TvShow(
                "246",
                "Avatar: The Last Airbender",
                "/sB8V0pQtJZ17v8FLXMOcYz6045c.jpg",
                "In a war-torn world of elemental magic, a young boy reawakens to" +
                        " undertake a dangerous mystic quest to fulfill his destiny as the " +
                        "Avatar, and bring peace to the world.",
                "2005-02-21",
                "8.3"
            )
        )

        tvShow.add(
            TvShow(
                "1438",
                "The Wire",
                "/dg7NuKDjmS6OzuNy33qt8kSkPA1.jpg",
                "Told from the points of view of both the Baltimore homicide and" +
                        " narcotics detectives and their targets, the series captures a universe" +
                        " in which the national war on drugs has become a permanent, " +
                        "self-sustaining bureaucracy, and distinctions between good and evil " +
                        "are routinely obliterated.",
                "2002-06-02",
                "8.3"
            )
        )

        tvShow.add(
            TvShow(
                "1398",
                "The Sopranos",
                "/u0cLcBQITrYqfHsn06fxnQwtqiE.jpg",
                "The story of New Jersey-based Italian-American mobster Tony Soprano " +
                        "and the difficulties he faces as he tries to balance the conflicting " +
                        "requirements of his home life and the criminal organization he heads. " +
                        "Those difficulties are often highlighted through his ongoing " +
                        "professional relationship with psychiatrist Jennifer Melfi. The show " +
                        "features Tony's family members and Mafia associates in prominent roles" +
                        " and story arcs, most notably his wife Carmela and his cousin and " +
                        "protégé Christopher Moltisanti.",
                "1999-01-10",
                "8.3"
            )
        )

        tvShow.add(
            TvShow(
                "68595",
                "Planet Earth II",
                "/uy5QoTu8fc6fGXMCTMbpQJFUEB0.jpg",
                "David Attenborough presents a documentary series exploring how" +
                        " animals meet the challenges of surviving in the most iconic" +
                        " habitats on earth.",
                "2016-11-06",
                "8.3"
            )
        )

        tvShow.add(
            TvShow(
                "72844",
                "The Haunting",
                "/38PkhBGRQtmVx2drvPik3F42qHO.jpg",
                "The Crains, a fractured family, confront haunting memories of" +
                        " their old home and the terrifying events that drove them from it.",
                "2018-10-12",
                "8.3"
            )
        )

        tvShow.add(
            TvShow(
                "1400",
                "Seinfeld",
                "/aCw8ONfyz3AhngVQa1E2Ss4KSUQ.jpg",
                "A stand-up comedian and his three offbeat friends weather the " +
                        "pitfalls and payoffs of life in New York City in the '90s. It's a" +
                        " show about nothing.",
                "1989-07-05",
                "8.2"
            )
        )

        tvShow.add(
            TvShow(
                "1044",
                "Planet Earth",
                "/tI5hLHgrfOTOhPjX22vlo9YsdgE.jpg",
                "David Attenborough celebrates the amazing variety of the natural" +
                        " world in this epic documentary series, filmed over four years across" +
                        " 64 different countries.",
                "2006-03-05",
                "8.3"
            )
        )

        tvShow.add(
            TvShow(
                "70796",
                "The Marvelous Mrs. Maisel",
                "/7qxLUcNim8C8x3Bbe10oo12Qywi.jpg",
                "It’s 1958 Manhattan and Miriam “Midge” Maisel has everything" +
                        " she’s ever wanted - the perfect husband, kids, and Upper West Side" +
                        " apartment. But when her life suddenly takes a turn and Midge must start" +
                        " over, she discovers a previously unknown talent - one that will take " +
                        "her all the way from the comedy clubs of Greenwich Village to a spot" +
                        " on Johnny Carson’s couch.",
                "2017-03-16",
                "8.3"
            )
        )

        tvShow.add(
            TvShow(
                "849",
                "Monty Python's Flying Circus",
                "/nKiyYqYcRcQLgkLk0LFtRgtGMen.jpg",
                "A British sketch comedy series with the shows being composed of " +
                        "surreality, risqué or innuendo-laden humour, sight gags and " +
                        "observational sketches without punchlines.",
                "1969-10-05",
                "8.3"
            )
        )

        return tvShow
    }



}