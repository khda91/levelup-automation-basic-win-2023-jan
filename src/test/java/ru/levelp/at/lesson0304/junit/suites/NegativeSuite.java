package ru.levelp.at.lesson0304.junit.suites;

import org.junit.platform.suite.api.IncludeClassNamePatterns;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import ru.levelp.at.lesson0304.junit.tags.TagNames;

@Suite
@IncludeTags({TagNames.NEGATIVE_TAG_NAME})
@SelectPackages("ru.levelp.at.lesson0304.junit")
@IncludeClassNamePatterns(".*IT")
public class NegativeSuite {
}
