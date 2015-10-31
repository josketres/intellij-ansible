package lv.kid.vermut.intellij.yaml.parser;

import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import lv.kid.vermut.intellij.yaml.YamlLanguage;
import lv.kid.vermut.intellij.yaml.lexer.YamlTokenTypesOld;

/**
 * Types of elements returned from parser
 */
@Deprecated
public interface NeonElementTypes {
    public static final IFileElementType FILE = new IFileElementType(YamlLanguage.INSTANCE);

    public static final NeonElementType KEY_VALUE_PAIR = new NeonElementType("Key value pair");
    public static final NeonElementType KEY = new NeonElementType("Key");
    public static final NeonElementType COMPOUND_KEY = new NeonElementType("Compound key");
    public static final NeonElementType HASH = new NeonElementType("Hash");
    public static final NeonElementType ITEM = new NeonElementType("Item");
    public static final NeonElementType ENTITY = new NeonElementType("Entity");
    public static final NeonElementType JINJA = new NeonElementType("Jinja2");

    public static final NeonElementType ARRAY = new NeonElementType("Array");
    public static final NeonElementType ARGS = new NeonElementType("Args");
    public static final NeonElementType SEQUENCE = new NeonElementType("Sequence");
    public static final NeonElementType COMPOUND_VALUE = new NeonElementType("Compound value");
    public static final NeonElementType SCALAR_VALUE = new NeonElementType("Scalar value");
    public static final NeonElementType REFERENCE = new NeonElementType("Reference");

    public static final TokenSet SCALAR_VALUES = TokenSet.create(
            YamlTokenTypesOld.NEON_STRING,
            YamlTokenTypesOld.NEON_NUMBER,
            YamlTokenTypesOld.NEON_REFERENCE,
            YamlTokenTypesOld.NEON_IDENTIFIER,
            YamlTokenTypesOld.NEON_LITERAL,
            YamlTokenTypesOld.NEON_VARIABLE,
            YamlTokenTypesOld.NEON_DOUBLE_COLON, YamlTokenTypesOld.NEON_DOLLAR, YamlTokenTypesOld.NEON_AT
    );
}
