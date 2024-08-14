package ex_240813;

// 제네릭
// 클래스에서는 타입을 열어주고 객체 생성 시 타입을 강제하기 위해 사용
// 제네릭을 쓰지 않으면 Object 클래스를 최상위로 하기 때문에
// 오브젝트는 모든 것을 자식으로 받아주기 때문에 메인 객체 생성 시 런타임 에러를 발생시킬 수 있다.
public class Box<T> {
    private T obj;

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

}
