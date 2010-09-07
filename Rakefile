require 'rubygems'
require 'rake'

begin
  require 'jeweler'
  Jeweler::Tasks.new do |gem|
    gem.name = "cipango-jars"
    gem.summary = "Cipango and Jetty minimal dependencies"
    gem.description = "Cipango and Jetty minimal dependencies" 
    gem.email = "dominique.broeglin@gmail.com"
    gem.homepage = "http://github.com/dbroeglin/cipango-jars"
    gem.authors = ["Dominique Broeglin"]
    gem.files += Dir['lib/**/*.jar']
    # gem is a Gem::Specification... see http://www.rubygems.org/read/chapter/20 for additional settings
  end
  Jeweler::GemcutterTasks.new
rescue LoadError
  puts "Jeweler (or a dependency) not available. Install it with: gem install jeweler"
end

task :default => :build

require 'rake/rdoctask'
Rake::RDocTask.new do |rdoc|
  version = File.exist?('VERSION') ? File.read('VERSION') : ""

  rdoc.rdoc_dir = 'rdoc'
  rdoc.title = "cipango-jars #{version}"
  rdoc.rdoc_files.include('README*')
  rdoc.rdoc_files.include('lib/**/*.rb')
end
