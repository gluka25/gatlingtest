// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package books.books_1801_caad7f

@SerialVersionUID(0L)
final case class Book(
    id: _root_.scala.Int = 0,
    title: _root_.scala.Predef.String = "",
    author: _root_.scala.Predef.String = "",
    unknownFields: _root_.scalapb.UnknownFieldSet = _root_.scalapb.UnknownFieldSet.empty
    ) extends scalapb.GeneratedMessage with scalapb.lenses.Updatable[Book] {
    @transient
    private[this] var __serializedSizeCachedValue: _root_.scala.Int = 0
    private[this] def __computeSerializedValue(): _root_.scala.Int = {
      var __size = 0
      
      {
        val __value = id
        if (__value != 0) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeInt32Size(1, __value)
        }
      };
      
      {
        val __value = title
        if (!__value.isEmpty) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(2, __value)
        }
      };
      
      {
        val __value = author
        if (!__value.isEmpty) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(3, __value)
        }
      };
      __size += unknownFields.serializedSize
      __size
    }
    override def serializedSize: _root_.scala.Int = {
      var read = __serializedSizeCachedValue
      if (read == 0) {
        read = __computeSerializedValue()
        __serializedSizeCachedValue = read
      }
      read
    }
    def writeTo(`_output__`: _root_.com.google.protobuf.CodedOutputStream): _root_.scala.Unit = {
      {
        val __v = id
        if (__v != 0) {
          _output__.writeInt32(1, __v)
        }
      };
      {
        val __v = title
        if (!__v.isEmpty) {
          _output__.writeString(2, __v)
        }
      };
      {
        val __v = author
        if (!__v.isEmpty) {
          _output__.writeString(3, __v)
        }
      };
      unknownFields.writeTo(_output__)
    }
    def withId(__v: _root_.scala.Int): Book = copy(id = __v)
    def withTitle(__v: _root_.scala.Predef.String): Book = copy(title = __v)
    def withAuthor(__v: _root_.scala.Predef.String): Book = copy(author = __v)
    def withUnknownFields(__v: _root_.scalapb.UnknownFieldSet) = copy(unknownFields = __v)
    def discardUnknownFields = copy(unknownFields = _root_.scalapb.UnknownFieldSet.empty)
    def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = {
      (__fieldNumber: @_root_.scala.unchecked) match {
        case 1 => {
          val __t = id
          if (__t != 0) __t else null
        }
        case 2 => {
          val __t = title
          if (__t != "") __t else null
        }
        case 3 => {
          val __t = author
          if (__t != "") __t else null
        }
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      _root_.scala.Predef.require(__field.containingMessage eq companion.scalaDescriptor)
      (__field.number: @_root_.scala.unchecked) match {
        case 1 => _root_.scalapb.descriptors.PInt(id)
        case 2 => _root_.scalapb.descriptors.PString(title)
        case 3 => _root_.scalapb.descriptors.PString(author)
      }
    }
    def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToUnicodeString(this)
    def companion = books.books_1801_caad7f.Book
}

object Book extends scalapb.GeneratedMessageCompanion[books.books_1801_caad7f.Book] {
  implicit def messageCompanion: scalapb.GeneratedMessageCompanion[books.books_1801_caad7f.Book] = this
  def merge(`_message__`: books.books_1801_caad7f.Book, `_input__`: _root_.com.google.protobuf.CodedInputStream): books.books_1801_caad7f.Book = {
    var __id = `_message__`.id
    var __title = `_message__`.title
    var __author = `_message__`.author
    var `_unknownFields__`: _root_.scalapb.UnknownFieldSet.Builder = null
    var _done__ = false
    while (!_done__) {
      val _tag__ = _input__.readTag()
      _tag__ match {
        case 0 => _done__ = true
        case 8 =>
          __id = _input__.readInt32()
        case 18 =>
          __title = _input__.readStringRequireUtf8()
        case 26 =>
          __author = _input__.readStringRequireUtf8()
        case tag =>
          if (_unknownFields__ == null) {
            _unknownFields__ = new _root_.scalapb.UnknownFieldSet.Builder(_message__.unknownFields)
          }
          _unknownFields__.parseField(tag, _input__)
      }
    }
    books.books_1801_caad7f.Book(
        id = __id,
        title = __title,
        author = __author,
        unknownFields = if (_unknownFields__ == null) _message__.unknownFields else _unknownFields__.result()
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[books.books_1801_caad7f.Book] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      _root_.scala.Predef.require(__fieldsMap.keys.forall(_.containingMessage == scalaDescriptor), "FieldDescriptor does not match message type.")
      books.books_1801_caad7f.Book(
        id = __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).map(_.as[_root_.scala.Int]).getOrElse(0),
        title = __fieldsMap.get(scalaDescriptor.findFieldByNumber(2).get).map(_.as[_root_.scala.Predef.String]).getOrElse(""),
        author = __fieldsMap.get(scalaDescriptor.findFieldByNumber(3).get).map(_.as[_root_.scala.Predef.String]).getOrElse("")
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = Books1801Caad7FProto.javaDescriptor.getMessageTypes.get(1)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = Books1801Caad7FProto.scalaDescriptor.messages(1)
  def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[_] = throw new MatchError(__number)
  lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]] = Seq.empty
  def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[_] = throw new MatchError(__fieldNumber)
  lazy val defaultInstance = books.books_1801_caad7f.Book(
    id = 0,
    title = "",
    author = ""
  )
  implicit class BookLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, books.books_1801_caad7f.Book]) extends _root_.scalapb.lenses.ObjectLens[UpperPB, books.books_1801_caad7f.Book](_l) {
    def id: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Int] = field(_.id)((c_, f_) => c_.copy(id = f_))
    def title: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.title)((c_, f_) => c_.copy(title = f_))
    def author: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.author)((c_, f_) => c_.copy(author = f_))
  }
  final val ID_FIELD_NUMBER = 1
  final val TITLE_FIELD_NUMBER = 2
  final val AUTHOR_FIELD_NUMBER = 3
  def of(
    id: _root_.scala.Int,
    title: _root_.scala.Predef.String,
    author: _root_.scala.Predef.String
  ): _root_.books.books_1801_caad7f.Book = _root_.books.books_1801_caad7f.Book(
    id,
    title,
    author
  )
  // @@protoc_insertion_point(GeneratedMessageCompanion[books.Book])
}
