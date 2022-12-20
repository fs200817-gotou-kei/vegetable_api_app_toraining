package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Vegetable;
import com.example.demo.repository.VegetableRepository;

@Service
public class VegetableService {

    @Autowired
    private VegetableRepository vegetableRepository;

    // 空の場合はcontrollerでstatuscode決める際にやってやればいい(sutatuscodeを決めるのだからそのためのロジックがあるのは自然)
    // TODO: ここではinternalserverエラーのような具体的でないエラーをThrowするだけでよさそう
    // TODO: メソッドにthrows記載してなかった場合で最後のthrow
    // Exception以外のif文内でエラー出たらcontrollerに返してくれるってこと？
    public List<Vegetable> getAll(String name) throws Exception {
        // if (name == null)
        // // *内部でエラー出たら勝手にthrowされるっぽい、この場合はcontrollerへ
        // return this.vegetableRepository.findAll();

        // if (name != null)
        // return this.vegetableRepository.findByNameContaining(name);

        // TODO: 上の条件分岐だとdead codeと出てしまう(ここに行く前にthrowされてるってことかな？)
        // →だとすると↓が役に立ってない
        // throw new Exception();

        // TODO: ↓がいいのかな？(throwの範囲など検証してみないとわからないね)
        // TODO: ブレークポイントで検証
        try {
            if (name == null)
                // *内部でエラー出たら勝手にthrowされるっぽい、この場合はserviceへ
                return this.vegetableRepository.findAll();

            return this.vegetableRepository.findByNameContaining(name);
        } catch (Exception e) {
            throw new Exception();
        }
    }

    public Vegetable getById(long id) throws Exception {
        Optional<Vegetable> resultVegetable = this.vegetableRepository.findById(id);
        if (resultVegetable.isPresent()) {
            // TODO: loggerで出力
            return resultVegetable.get();
        }
        // TODO: ifいるかどうか
        // TODO: ↓多分違う
        if (resultVegetable.isEmpty()) {
            return null;
        }
        throw new Exception();
    }

    public Vegetable create(Vegetable vegetable) throws Exception {
        // TODO: tryで囲ってない時にデータ保存できなかった時の挙動
        Vegetable resultVegetable = this.vegetableRepository.save(vegetable);

        if (resultVegetable != null) {
            return resultVegetable;
        }
        // TODO: printとの表記の違い
        throw new Exception();

    }

    // idのデータあるかチェックする(Optionalに入れる)、ない場合はnull入れてcontrollerでNotFoundExcetionで、それ以外ならThrow投げる
    public Vegetable update(long id, Vegetable vegetable) throws Exception {
        Vegetable vegetableData = this.getById(id);

        if (vegetableData != null) {
            vegetableData.setName(vegetable.getName());
            vegetableData.setColor(vegetable.getColor());
            vegetableData.setPrice(vegetable.getPrice());
            return this.vegetableRepository.save(vegetableData);
        }
        // TODO: あくまでここまで行ったらException投げるって感じだね。
        // だからtryとかしないと途中でのエラーは対応できてないっぽい
        throw new Exception();
    }

    public void deleteAll() throws Exception {
        this.vegetableRepository.deleteAll();
    }

    public void deleteById(long id) throws Exception {
        try {
            Vegetable vegetableData = this.getById(id);
            if (vegetableData != null)
                this.vegetableRepository.deleteById(id);
        } catch (Exception e) {
            throw new Exception();
        }
    }
}
