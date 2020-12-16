package books.books_1801_caad7f

object BookServiceGrpc {
  val METHOD_LIST: _root_.io.grpc.MethodDescriptor[books.books_1801_caad7f.Empty, books.books_1801_caad7f.BookList] =
    _root_.io.grpc.MethodDescriptor.newBuilder()
      .setType(_root_.io.grpc.MethodDescriptor.MethodType.UNARY)
      .setFullMethodName(_root_.io.grpc.MethodDescriptor.generateFullMethodName("books.BookService", "List"))
      .setSampledToLocalTracing(true)
      .setRequestMarshaller(_root_.scalapb.grpc.Marshaller.forMessage[books.books_1801_caad7f.Empty])
      .setResponseMarshaller(_root_.scalapb.grpc.Marshaller.forMessage[books.books_1801_caad7f.BookList])
      .setSchemaDescriptor(_root_.scalapb.grpc.ConcreteProtoMethodDescriptorSupplier.fromMethodDescriptor(books.books_1801_caad7f.Books1801Caad7FProto.javaDescriptor.getServices.get(0).getMethods.get(0)))
      .build()
  
  val SERVICE: _root_.io.grpc.ServiceDescriptor =
    _root_.io.grpc.ServiceDescriptor.newBuilder("books.BookService")
      .setSchemaDescriptor(new _root_.scalapb.grpc.ConcreteProtoFileDescriptorSupplier(books.books_1801_caad7f.Books1801Caad7FProto.javaDescriptor))
      .addMethod(METHOD_LIST)
      .build()
  
  trait BookService extends _root_.scalapb.grpc.AbstractService {
    override def serviceCompanion = BookService
    def list(request: books.books_1801_caad7f.Empty): scala.concurrent.Future[books.books_1801_caad7f.BookList]
  }
  
  object BookService extends _root_.scalapb.grpc.ServiceCompanion[BookService] {
    implicit def serviceCompanion: _root_.scalapb.grpc.ServiceCompanion[BookService] = this
    def javaDescriptor: _root_.com.google.protobuf.Descriptors.ServiceDescriptor = books.books_1801_caad7f.Books1801Caad7FProto.javaDescriptor.getServices.get(0)
    def scalaDescriptor: _root_.scalapb.descriptors.ServiceDescriptor = books.books_1801_caad7f.Books1801Caad7FProto.scalaDescriptor.services(0)
    def bindService(serviceImpl: BookService, executionContext: scala.concurrent.ExecutionContext): _root_.io.grpc.ServerServiceDefinition =
      _root_.io.grpc.ServerServiceDefinition.builder(SERVICE)
      .addMethod(
        METHOD_LIST,
        _root_.io.grpc.stub.ServerCalls.asyncUnaryCall(new _root_.io.grpc.stub.ServerCalls.UnaryMethod[books.books_1801_caad7f.Empty, books.books_1801_caad7f.BookList] {
          override def invoke(request: books.books_1801_caad7f.Empty, observer: _root_.io.grpc.stub.StreamObserver[books.books_1801_caad7f.BookList]): Unit =
            serviceImpl.list(request).onComplete(scalapb.grpc.Grpc.completeObserver(observer))(
              executionContext)
        }))
      .build()
  }
  
  trait BookServiceBlockingClient {
    def serviceCompanion = BookService
    def list(request: books.books_1801_caad7f.Empty): books.books_1801_caad7f.BookList
  }
  
  class BookServiceBlockingStub(channel: _root_.io.grpc.Channel, options: _root_.io.grpc.CallOptions = _root_.io.grpc.CallOptions.DEFAULT) extends _root_.io.grpc.stub.AbstractStub[BookServiceBlockingStub](channel, options) with BookServiceBlockingClient {
    override def list(request: books.books_1801_caad7f.Empty): books.books_1801_caad7f.BookList = {
      _root_.scalapb.grpc.ClientCalls.blockingUnaryCall(channel, METHOD_LIST, options, request)
    }
    
    override def build(channel: _root_.io.grpc.Channel, options: _root_.io.grpc.CallOptions): BookServiceBlockingStub = new BookServiceBlockingStub(channel, options)
  }
  
  class BookServiceStub(channel: _root_.io.grpc.Channel, options: _root_.io.grpc.CallOptions = _root_.io.grpc.CallOptions.DEFAULT) extends _root_.io.grpc.stub.AbstractStub[BookServiceStub](channel, options) with BookService {
    override def list(request: books.books_1801_caad7f.Empty): scala.concurrent.Future[books.books_1801_caad7f.BookList] = {
      _root_.scalapb.grpc.ClientCalls.asyncUnaryCall(channel, METHOD_LIST, options, request)
    }
    
    override def build(channel: _root_.io.grpc.Channel, options: _root_.io.grpc.CallOptions): BookServiceStub = new BookServiceStub(channel, options)
  }
  
  def bindService(serviceImpl: BookService, executionContext: scala.concurrent.ExecutionContext): _root_.io.grpc.ServerServiceDefinition = BookService.bindService(serviceImpl, executionContext)
  
  def blockingStub(channel: _root_.io.grpc.Channel): BookServiceBlockingStub = new BookServiceBlockingStub(channel)
  
  def stub(channel: _root_.io.grpc.Channel): BookServiceStub = new BookServiceStub(channel)
  
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.ServiceDescriptor = books.books_1801_caad7f.Books1801Caad7FProto.javaDescriptor.getServices.get(0)
  
}