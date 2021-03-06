package service_client.client;

import lombok.val;
import org.junit.Test;
import service_client.data.Lesson;
import service_client.data.request.LessonCreation;

import java.util.List;
import java.util.Random;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class LessonClientTest {
    private LessonClient client = new LessonClient();

    @Test
    public void get() throws Exception {
        Lesson lesson = client.get(1L);
        assertNotNull(lesson);
    }

    @Test
    public void getList() throws Exception {
        List<Lesson> lessons = client.getList();
        assertNotNull(lessons);
        assertThat(lessons.isEmpty(), is(false));
    }

    @Test
    public void add() throws Exception {
        val name = "test 423";
        val lessonCreation = new LessonCreation(name, "desc");
        val lesson = client.add(lessonCreation);
        assertNotNull(lesson);
        assertThat(lesson.getName(), is(name));
    }

    @Test
    public void update() throws Exception {
        val newName = "sdASdsgsdgsdg" + new Random().nextInt();
        val lesson = client.get(1L);
        lesson.setName(newName);
        val updatedLesson = client.update(lesson);
        assertThat(updatedLesson.getName(), is(newName));
    }
}