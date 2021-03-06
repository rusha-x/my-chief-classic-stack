package rusha.x.recipe.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import rusha.x.R
import rusha.x.recipe.Recipe

/**
 * Преобразует список [ingredientsToAdopt] в отображение списка в [ingredientsView]
 */
//класс наследуется от класса Adapter
// в скобочках говрится "класс IngredientViewHolder это ячейка для класса IngredientsListAdapter
//IngredientsListAdapter это адаптер для того внутри <...>
// TODO определяем что все IngredientsListAdapter являются RecyclerView.Adapter-ами для
// TODO которых VH (ViewHolder) - это IngredientViewHolder
class IngredientsListAdapter(
    private val viewModel: RecipeDetailsViewModel
) : RecyclerView.Adapter<IngredientViewHolder>() {

    /**
     * Список который адаптирует [IngredientsListAdapter]
     */
    //ingredientsToAdopt это список который отображает IngredientsListAdapter
    //"в ingredientsToAdopt изначально лежит пустой список(listOf)
    // TODO определяем что ingredientsToAdopt является списком из Recipe.Ingredient-ов
    // TODO который является пустым списком
    var ingredientsToAdopt: List<Recipe.Ingredient> = listOf()

    /**
     * Создать ячейку для RecyclerView, лежащего в [parent]
     */
    // TODO в отличие от других RecyclerView.Adapter, IngredientsListAdapter делает onCreateViewHolder
    override fun onCreateViewHolder(
        parent: ViewGroup, // TODO для parent, который является ViewGroup
        viewType: Int // TODO и viewType, который является Int
    ): IngredientViewHolder { // TODO в результате отдавая что-то являющееся IngredientViewHolder-ом

        /**
        Получить [LayoutInflater] из текущего контекста
        который можно получить из любого отображения в этом контексте
         */
        // inflater переменная содержит в себе LayoutInflater, который мы получили из context,
        // который находится в parent
        // TODO определяем что inflater это LayoutInflater из context-а parent
        val inflater = LayoutInflater.from(parent.context)

        /**
        "Надуть" [R.layout.recipe_details_item] так чтобы потом поместить его в [parent]
        Не нужно привязывать его к [parent] сразу. Поэтому 3 аргумет = false
         */
        // обьявляем переменную вью которая является результатом вызова функции inflate
        // TODO определяем что view мы получим в резульате inflate inflater-а
        val view = inflater.inflate(
            /**
             * R - ресурсы (это то, что может меняться в зависимости от того, на каком
             * устройсте запущено приложение. Например, мы можем загрузить в приложение
             * иконки разного качества. В зависимости от плотности точек экрана, будут
             * использоваться разные иконки)
             *
             * layout - папка с файлами разметки. Можно использовать разные разметки для
             * разных экранов или отдельную для вертикального и горизонтального положений
             * экрана
             *
             * recipe_details_item - название файла надуваемой разметки (верстки)
             */
            // TODO которому мы даём R.layout.recipe_details_item в качестве resource
            R.layout.recipe_details_item,
            /**
             * В какое отображение будет помещено отображение, полученное в результате
             * надувания вёрстки
             */
            // TODO parent в качесте root
            parent,
            /**
             * Нужно ли сразу прикрепить надутую вёрстку к parent
             */
            // TODO false в качестве attackToRoot
            false
        )

        /**
         * Создать держатель отображения у которого в качестве отображения
         * будет значение переменной [view]
         * Держатель отображения будет результатом вызова функции [onCreateViewHolder].
         * RecyclerView вызовет эту функцию и положит ячейку, полученную в результате
         * в пул ячеек, некоторые из которых некоторые сразу заполнит и отобразит пользователю,
         * а некоторые - будет держать "на изготове"
         */
        // TODO отдаём то, что получим в результате создания IngredientViewHolder
        // TODO для которого cellView - это view
        return IngredientViewHolder(cellView = view, viewModel = viewModel)
    }

    /**
     * Попросить держатель отображения ячейки [holder] заполнить отображение внутри него
     * элементом из списка [ingredientsToAdopt] по позиции [position]
     */
    // TODO в отличие от других RecyclerView.Adapter-ов, IngredientsListAdapter делает onBindViewHolder
    override fun onBindViewHolder(
        holder: IngredientViewHolder, // TODO с holder, который является IngredientViewHolder
        position: Int // TODO и с position, который является Int
    ) {
        /**
         * Получить ингридиент по позиции [position]
         */
        // TODO определяем что ingredientOnPosition мы получим в результате получения элемента
        // TODO из списка ingredientsToAdopt по индексу, равному position
        val ingredientOnPosition = ingredientsToAdopt.get(index = position)

        /**
         * Попросить ячейку заполниться этим игридиентом
         */
        // TODO делаем bind у holder-а где ingredient - это то же, что и ingredientOnPosition
        holder.bind(ingredient = ingredientOnPosition)
    }

    /**
     * Сделать так чтобы [onBindViewHolder] не вызвалась с позицией (position)
     * которой нет в списке
     */
    override fun getItemCount(): Int {
        return ingredientsToAdopt.size
    }
}