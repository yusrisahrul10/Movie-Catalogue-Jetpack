package me.yusrisahrul.moviecatalogue.utils

import me.yusrisahrul.moviecatalogue.model.Movie
import me.yusrisahrul.moviecatalogue.model.TvShow

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

}