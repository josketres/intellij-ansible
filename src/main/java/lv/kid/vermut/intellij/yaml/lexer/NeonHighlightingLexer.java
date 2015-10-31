package lv.kid.vermut.intellij.yaml.lexer;

import com.intellij.lexer.Lexer;
import com.intellij.lexer.LookAheadLexer;
import com.intellij.psi.tree.IElementType;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Lexer used for syntax highlighting
 *
 * It reuses the simple lexer, changing types of some tokens
 */
public class NeonHighlightingLexer extends LookAheadLexer {

	private static final Set<String> KEYWORDS = new HashSet<String>(Arrays.asList(
		new String[]{
			"true", "True", "TRUE", "yes", "Yes", "YES", "on", "On", "ON",
			"false", "False", "FALSE", "no", "No", "NO", "off", "Off", "OFF",
			"null", "Null", "NULL"
		}
	));

	public NeonHighlightingLexer(Lexer baseLexer) {
		super(baseLexer, 1);
	}

	@Override
	protected void lookAhead(Lexer baseLexer) {
		IElementType currentToken = baseLexer.getTokenType();

		if (currentToken == YamlTokenTypesOld.NEON_LITERAL && KEYWORDS.contains(baseLexer.getTokenText())) {
			advanceLexer(baseLexer);
			replaceCachedType(0, YamlTokenTypesOld.NEON_KEYWORD);

		} else if (currentToken == YamlTokenTypesOld.NEON_LITERAL || currentToken == YamlTokenTypesOld.NEON_STRING) {
			advanceLexer(baseLexer);

			if (baseLexer.getTokenType() == YamlTokenTypesOld.NEON_WHITESPACE) {
				advanceLexer(baseLexer);
			}

			if (baseLexer.getTokenType() == YamlTokenTypesOld.NEON_COLON) {
				advanceLexer(baseLexer);
				replaceCachedType(0, YamlTokenTypesOld.NEON_KEY);
			}

		} else {
			super.lookAhead(baseLexer);
		}
	}
}
